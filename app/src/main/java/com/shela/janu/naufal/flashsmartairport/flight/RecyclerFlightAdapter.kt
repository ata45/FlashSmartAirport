package com.shela.janu.naufal.flashsmartairport.flight

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.Flight
import kotlinx.android.synthetic.main.card_flights.view.*

class RecyclerFlightAdapter (private val context: Context, private val flights : List<Flight>)
    : RecyclerView.Adapter<RecyclerFlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_flights, p0, false))
    }

    override fun getItemCount(): Int {
        return flights.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding(flights[p1], context)
    }

    class ViewHolder (private val containerView : View) : RecyclerView.ViewHolder(containerView){

        @SuppressLint("SetTextI18n")
        fun binding(flight : Flight, context: Context){

            containerView.plane_name.text = flight.planeName
            containerView.time_flight.text = flight.departureTime + " - " + flight.arriveTime
            containerView.from_to_flight.text = "Non Stop " + flight.fromPlace + " - " + flight.toPlace
            flight.planeImage?.let { Glide.with(context).load(it).into(containerView.image_plane)}
        }
    }
}