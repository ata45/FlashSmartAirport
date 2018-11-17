package com.shela.janu.naufal.flashsmartairport.flight

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.db.FlightSchedule
import com.shela.janu.naufal.flashsmartairport.db.database
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.model.Flight
import kotlinx.android.synthetic.main.card_flights.view.*
import kotlinx.android.synthetic.main.fragment_myflight.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class RecyclerFlightAdapter(private val context: Context, private val flights: List<Flight>) :
    RecyclerView.Adapter<RecyclerFlightAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_flights, p0, false))
    }

    override fun getItemCount(): Int {
        return flights.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding(flights[p1], context)
    }

    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {


        private var isSchedule: Boolean = false


        @SuppressLint("SetTextI18n")
        fun binding(flight: Flight, context: Context) {

            scheduleState(context, flight)
            checkSchedule(flight, context, containerView)

            containerView.plane_name.text = flight.planeName
            containerView.time_flight.text = flight.departureTime + " - " + flight.arriveTime + " ("+ flight.codeFlight + ")"
            containerView.from_to_flight.text = "Non Stop " + flight.fromPlace + " - " + flight.toPlace
            flight.planeImage?.let { Glide.with(context).load(it).into(containerView.image_plane) }
        }

        private fun addSchedule(flight: Flight, context: Context, containerView: View) {

            try {
                context.database.use {
                    insert(
                        FlightSchedule.TABLE_FLIGHT,
                        FlightSchedule.ID_FLIGHT to flight.idFlight,
                        FlightSchedule.CODE_FLIGHT to flight.codeFlight,
                        FlightSchedule.FLIGHT_TYPE to flight.flightType,
                        FlightSchedule.DEPART_TIME to flight.departureTime,
                        FlightSchedule.ARRIVE_TIME to flight.arriveTime,
                        FlightSchedule.PLANE_NAME to flight.planeName,
                        FlightSchedule.FROM_PLACE to flight.fromPlace,
                        FlightSchedule.TO_PLACE to flight.toPlace,
                        FlightSchedule.PLANE_IMAGE to flight.planeImage
                    )
                }
                Snackbar.make(
                    containerView.card_parent_flight,
                    context.getString(R.string.add_success),
                    Snackbar.LENGTH_SHORT
                ).show()
                isSchedule = true
                checkSchedule(flight, context, containerView)
            } catch (e: SQLiteConstraintException) {
                Snackbar.make(
                    containerView.card_parent_flight,
                    "" + e.localizedMessage,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        private fun removeFromSchedule(flight: Flight, context: Context, containerView: View) {

            val idFlight = flight.idFlight.toString()
            try {
                context.database.use {
                    delete(FlightSchedule.TABLE_FLIGHT, "(ID_FLIGHT = {id})", "id" to idFlight)
                }
                Snackbar.make(
                    containerView.card_parent_flight,
                    context.getString(R.string.delete_schedule),
                    Snackbar.LENGTH_SHORT
                ).show()

                isSchedule = false
                checkSchedule(flight, context, containerView)

            } catch (e: SQLiteConstraintException) {

                Snackbar.make(
                    containerView.card_parent_flight,
                    "" + e.localizedMessage,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        private fun checkSchedule(flight: Flight, context: Context, containerView: View) {
            if (isSchedule) {

                containerView.btn_add_schedule.setBackgroundResource(R.drawable.ic__remove_schedule)
                containerView.btn_add_schedule.isActivated = false
                containerView.btn_add_schedule.setOnClickListener {

                    removeFromSchedule(flight,context,containerView)

                }
            } else {

                containerView.btn_add_schedule.setBackgroundResource(R.drawable.ic__add_flight)
                containerView.btn_add_schedule.isActivated = true
                containerView.btn_add_schedule.setOnClickListener { addSchedule(flight, context, containerView) }

            }
        }

        private fun scheduleState(context: Context, flight: Flight) {

            val idFlight = flight.idFlight.toString()

            context.database.use {
                val result = select(FlightSchedule.TABLE_FLIGHT)
                    .whereArgs(
                        "(ID_FLIGHT = {id})",
                        "id" to idFlight
                    )
                val schedule = result.parseList(classParser<FlightSchedule>())
                if (!schedule.isEmpty()) isSchedule = true
            }
        }
    }


}