@file:Suppress("UNREACHABLE_CODE")

package com.shela.janu.naufal.flashsmartairport

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.facility.FacilityActivity
import com.shela.janu.naufal.flashsmartairport.flight.FlightActivity
import com.shela.janu.naufal.flashsmartairport.shop.ShopActivity
import com.shela.janu.naufal.flashsmartairport.transportation.TransportActivity
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.intentFor
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment(){


    @SuppressLint("SimpleDateFormat")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sdf = SimpleDateFormat("dd-M-yyyy")
        val currentDate = sdf.format(Date())

        date_now.text = currentDate

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_flight.setOnClickListener {
            activity?.startActivity(intentFor<FlightActivity>())
        }
        btn_facility.setOnClickListener{
            activity?.startActivity(intentFor<FacilityActivity>())
        }
        btn_transport.setOnClickListener{
            activity?.startActivity(intentFor<TransportActivity>())
        }
        btn_shop.setOnClickListener{
            activity?.startActivity(intentFor<ShopActivity>())
        }
    }

}