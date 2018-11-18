package com.shela.janu.naufal.flashsmartairport.flight.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.facility.RecyclerFacilityAdapter
import com.shela.janu.naufal.flashsmartairport.flight.RecyclerFlightAdapter
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.model.Flight
import kotlinx.android.synthetic.main.fragment_child_flight.*

class DepartureFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {


    private var flights: MutableList<Flight> = mutableListOf()
    private lateinit var adapter: RecyclerFlightAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Swipe_flight.setOnRefreshListener(this)
        getData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child_flight, container, false)
    }

    override fun onRefresh() {
        getData()
    }

    private fun getData() {

        flights.clear()
        for (i in DataStore.FlightList) {

            if (i.flightType == "departure") {
                flights.add(i)
            }
        }
        adapter = RecyclerFlightAdapter(this.context!!, flights)
        rcy_flights.layoutManager = LinearLayoutManager(activity)
        rcy_flights.adapter = adapter

        Swipe_flight.isRefreshing = false
    }
}