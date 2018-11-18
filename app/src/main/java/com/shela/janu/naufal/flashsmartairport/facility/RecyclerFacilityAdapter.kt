package com.shela.janu.naufal.flashsmartairport.facility

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.Facility
import kotlinx.android.synthetic.main.card_facilities.view.*

class RecyclerFacilityAdapter(private val context: Context, private val transports: List<Facility>):
    RecyclerView.Adapter<RecyclerFacilityAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_facilities, p0, false))
    }

    override fun getItemCount(): Int {
        return transports.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding(transports[p1], context, p1)
    }

    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun binding(facility: Facility, context: Context, position: Int) {

            if (position % 2 == 0) {

                val params = containerView.rl_card_facility.layoutParams as RelativeLayout.LayoutParams
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                containerView.rl_card_facility.layoutParams = params

            } else {
                val parameter = containerView.ll_desc_facility.layoutParams as FrameLayout.LayoutParams
                parameter.leftMargin = 200
                containerView.ll_desc_facility.layoutParams = parameter
            }


            containerView.facility_name.text = facility.facilityName
            containerView.facility_desc.text = facility.facilityDesc
            containerView.facility_time.text = facility.facilityArea
            facility.facilityImage?.let { Glide.with(context).load(it).into(containerView.image_facility) }
        }
    }
}