package com.shela.janu.naufal.flashsmartairport.transportation.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.model.Transportation
import com.shela.janu.naufal.flashsmartairport.transportation.RecyclerTransportAdapter

class RentFragment : Fragment() {

    private var transports : MutableList<Transportation> = mutableListOf()
    private lateinit var adapter : RecyclerTransportAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}