@file:Suppress("UNREACHABLE_CODE")

package com.shela.janu.naufal.flashsmartairport

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.checkin.CheckInActivity
import com.shela.janu.naufal.flashsmartairport.db.FlightSchedule
import com.shela.janu.naufal.flashsmartairport.db.database
import com.shela.janu.naufal.flashsmartairport.facility.FacilityActivity
import com.shela.janu.naufal.flashsmartairport.flight.FlightActivity
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.services.NotificationUtils
import com.shela.janu.naufal.flashsmartairport.shop.ShopActivity
import com.shela.janu.naufal.flashsmartairport.transportation.TransportActivity
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.support.v4.intentFor
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {


    private lateinit var flight: FlightSchedule
    private var flights: MutableList<FlightSchedule> = mutableListOf()
    private val mNotificationTime =
        Calendar.getInstance().timeInMillis + 5000 //Set after 5 seconds from the current time.
    private var mNotified = false


    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        scheduleState()

        // Jika tidak ada jadwal yg di simpan, makan muncul tampilaan, tidak ada jadwal\

        val sdf = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.US)
        val currentDate = sdf.format(Date())

        if (flights.size == 0) {

            txt_none_saved.visibility = View.VISIBLE
            rl_flight_schedule.visibility = View.INVISIBLE

        } else {
            txt_none_saved.visibility = View.INVISIBLE
            rl_flight_schedule.visibility = View.VISIBLE

            flight = flights[0]





            home_code_time_flight.text = currentDate + ", " + flight.departTime
            home_plane_name.text = flight.planeName
            home_from_to_flight.text = flight.fromPlace + " - " + flight.toPlace
            flight.planeImage?.let { Glide.with(activity).load(it.toInt()).into(home_image_plane) }


            DataStore.titleNotify = "Keberangkatan pukul "+ flight.departTime
            DataStore.bodyNotify = "Tujuan " + flight.toPlace + ", Pesawat " + flight.planeName

            if (!mNotified) NotificationUtils().setNotification(mNotificationTime, activity!!)
        }

        date_now.text = currentDate

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_flight.setOnClickListener {

            activity?.startActivity(intentFor<FlightActivity>())
            activity?.finish()
        }
        btn_facility.setOnClickListener {
            activity?.startActivity(intentFor<FacilityActivity>())
            activity?.finish()
        }
        btn_transport.setOnClickListener {
            activity?.startActivity(intentFor<TransportActivity>())
            activity?.finish()
        }
        btn_shop.setOnClickListener {
            activity?.startActivity(intentFor<ShopActivity>())
            activity?.finish()
        }
        btn_check.setOnClickListener {
            activity?.startActivity(intentFor<CheckInActivity>())
        }
        btn_maps.setOnClickListener {
            activity?.startActivity(intentFor<MapsActivity>())
            activity?.finish()
        }
    }

    private fun scheduleState() {
        activity?.database?.use {
            val result = select(FlightSchedule.TABLE_FLIGHT)
            flights.addAll(result.parseList(classParser()))
        }
    }

}