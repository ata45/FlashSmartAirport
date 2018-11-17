package com.shela.janu.naufal.flashsmartairport

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.db.FlightSchedule
import com.shela.janu.naufal.flashsmartairport.db.database
import com.shela.janu.naufal.flashsmartairport.model.Flight
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select


class MyFlightFragment : Fragment() {

    private lateinit var flight: Flight
    private  var isScheduled : Boolean = false
    private lateinit var idFlight : String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_myflight, container, false)
    }

    private fun addToFavorite() {
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
            /*Snackbar.make((R.id.rl_detail_team),
              "",
                Snackbar.LENGTH_SHORT
            ).show()*/
        } catch (e: SQLiteConstraintException) {
           /* Snackbar.make(
                (R.id.rl_detail_team),
                "" + e.localizedMessage,
                Snackbar.LENGTH_SHORT
            ).show()*/
        }
    }


    private fun removeFromFavorite() {
        try {
            activity?.database?.use {
               delete(FlightSchedule.TABLE_FLIGHT, "(ID_FLIGHT = {id})","id" to idFlight)
            }

        } catch (e: SQLiteConstraintException) {
        }
    }

    private fun setFavorite() {

    }

    private fun favoriteState() {
        activity?.database?.use {
            val result = select(FlightSchedule.TABLE_FLIGHT)
                .whereArgs(
                    "(ID_FLIGHT = {id})",
                    "id" to idFlight
                )
            val favorite = result.parseList(classParser<Flight>())
            if (!favorite.isEmpty()) isScheduled = true
        }
    }
}