package com.shela.janu.naufal.flashsmartairport

import android.app.DatePickerDialog
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.db.FlightSchedule
import com.shela.janu.naufal.flashsmartairport.db.database
import com.shela.janu.naufal.flashsmartairport.model.Flight
import kotlinx.android.synthetic.main.fragment_myflight.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.util.*
import android.annotation.SuppressLint
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.model.DataStore


class MyFlightFragment : Fragment() {

    private lateinit var flight: Flight
    private var isScheduled: Boolean = false
    private lateinit var idFlight: String
    private var count: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        edt_date.setOnClickListener {
            val c = Calendar.getInstance()
            val mYear = c.get(Calendar.YEAR)
            val mMonth = c.get(Calendar.MONTH)
            val mDay = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this.context!!,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth -> edt_date.setText(year.toString() + "-" + (month + 1) + "-" + dayOfMonth) },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }


        buttonSearchFlight.setOnClickListener {

            card_flight.visibility = View.INVISIBLE
            searchFlight(edit_code.text.toString())
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_myflight, container, false)
    }

    @SuppressLint("SetTextI18n")
    private fun searchFlight(id: String?) {

        for (i in DataStore.FlightList) {

            if (i.codeFlight == id) {
                count++
                flight = i
            }
        }

        idFlight = flight.idFlight!!

        if(count == 0){
            Snackbar.make(
                cl_myflight,
               getString(R.string.no_sched),
                Snackbar.LENGTH_SHORT
            ).show()
        }
        else{
            flight.codeFlight?.let {
                Snackbar.make(
                    cl_myflight,
                    it,
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            scheduleState()
            checkScheduleAdded()

            card_flight.visibility = View.VISIBLE

            flight.planeImage?.let { Glide.with(this).load(it).into(image_plane) }
            plane_name.text = flight.planeName
            time_flight.text = flight.departureTime + " - " + flight.arriveTime
            from_to_flight.text = "Non Stop " + flight.fromPlace + " - " + flight.toPlace


        }
    }

    private fun addToSchedule() {
        try {
            activity?.database?.use {
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
                cl_myflight,
                getString(R.string.add_success),
                Snackbar.LENGTH_SHORT
            ).show()
            isScheduled = true
            checkScheduleAdded()
        } catch (e: SQLiteConstraintException) {
            Snackbar.make(
                cl_myflight,
                "" + e.localizedMessage,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }


    private fun removeFromFavorite() {
        try {
            activity?.database?.use {
                delete(FlightSchedule.TABLE_FLIGHT, "(ID_FLIGHT = {id})", "id" to idFlight)
            }

        } catch (e: SQLiteConstraintException) {
        }
    }

    private fun checkScheduleAdded() {

        if(isScheduled){

            btn_add_schedule.setBackgroundResource(R.drawable.ic__added)
            btn_add_schedule.isActivated = false
            btn_add_schedule.setOnClickListener { Snackbar.make(
                cl_myflight,
               getString(R.string.already_added),
                Snackbar.LENGTH_SHORT
            ).show() }
        }
        else{

            btn_add_schedule.setBackgroundResource(R.drawable.ic__add_flight)
            btn_add_schedule.isActivated = true
            btn_add_schedule.setOnClickListener { addToSchedule() }

        }

    }
    private fun scheduleState() {
        activity?.database?.use {
            val result = select(FlightSchedule.TABLE_FLIGHT)
                .whereArgs(
                    "(ID_FLIGHT = {id})",
                    "id" to idFlight
                )
            val schedule = result.parseList(classParser<FlightSchedule>())
            if (!schedule.isEmpty()) isScheduled = true
        }
    }
}