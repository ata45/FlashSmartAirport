package com.shela.janu.naufal.flashsmartairport.facility.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.facility.RecyclerFacilityAdapter
import com.shela.janu.naufal.flashsmartairport.model.Facility

class AreaTwoFacilityFragment : Fragment() {

    private var Facilities : MutableList<Facility> = mutableListOf()
    private lateinit var adapter : RecyclerFacilityAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child_facilities, container, false)
    }
}