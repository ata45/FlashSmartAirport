package com.shela.janu.naufal.flashsmartairport.transportation

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.Transportation
import kotlinx.android.synthetic.main.card_transports.view.*
import android.widget.RelativeLayout
import org.jetbrains.anko.verticalMargin


class RecyclerTransportAdapter(private val context: Context, private val transports: List<Transportation>):
    RecyclerView.Adapter<RecyclerTransportAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_transports, p0, false))
    }

    override fun getItemCount(): Int {
        return transports.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding(transports[p1], context, p1)
    }

    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun binding(transportation: Transportation, context: Context, position: Int) {

            if (position % 2 != 0) {

                val params = containerView.rl_card_transport.layoutParams as RelativeLayout.LayoutParams
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                val parameter = containerView.ll_desc_transport.layoutParams as FrameLayout.LayoutParams
                parameter.rightMargin = 200
                containerView.rl_card_transport.layoutParams = params
                containerView.ll_desc_transport.layoutParams = parameter

            } else {
                val params = containerView.rl_card_transport.layoutParams as RelativeLayout.LayoutParams
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
                val parameter = containerView.ll_desc_transport.layoutParams as FrameLayout.LayoutParams
                parameter.leftMargin = 200
                containerView.ll_desc_transport.layoutParams = parameter
                containerView.rl_card_transport.layoutParams = params

            }

            containerView.transport_name.text = transportation.nameTransport
            containerView.transport_desc.text = transportation.descTransport
            containerView.transport_time.text = transportation.timeLineTransport
            transportation.ImageTransport?.let { Glide.with(context).load(it).into(containerView.image_transport) }
        }
    }
}