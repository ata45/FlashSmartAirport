package com.shela.janu.naufal.flashsmartairport.facility.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.facility.RecyclerFacilityAdapter
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.model.Facility
import kotlinx.android.synthetic.main.fragment_child_facilities.*
import org.jetbrains.anko.support.v4.intentFor

class AreaTwoFacilityFragment : Fragment() {

    private var facilities : MutableList<Facility> = mutableListOf()
    private lateinit var adapter : RecyclerFacilityAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        facilities.clear()

        for( i in DataStore.FacilityList){

            if( i.facilityArea == "Area2"){
                facilities.add(i)
            }
        }

        adapter = RecyclerFacilityAdapter(this.context!!, facilities)
        rcy_facilities.layoutManager = LinearLayoutManager(activity)
        rcy_facilities.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child_facilities, container, false)
    }
}