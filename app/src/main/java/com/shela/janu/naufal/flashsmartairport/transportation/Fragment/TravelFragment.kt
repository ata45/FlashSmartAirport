package com.shela.janu.naufal.flashsmartairport.transportation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.model.Transportation
import com.shela.janu.naufal.flashsmartairport.transportation.RecyclerTransportAdapter
import kotlinx.android.synthetic.main.fragment_child_transport.*
import org.jetbrains.anko.support.v4.intentFor

class TravelFragment : Fragment() {

    private var transports : MutableList<Transportation> = mutableListOf()
    private lateinit var adapter : RecyclerTransportAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        transports.clear()
        for( i in DataStore.TransportList){

            if( i.typeTransport == "Travel"){

                transports.add(i)
            }
        }

        adapter = RecyclerTransportAdapter(this.context!!, transports)
        rcy_transport.layoutManager = LinearLayoutManager(activity)
        rcy_transport.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child_transport, container, false)
    }
}