package com.shela.janu.naufal.flashsmartairport.shop.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.model.Shop
import com.shela.janu.naufal.flashsmartairport.shop.RecyclerShopAdapter

class AllShopFragment : Fragment() {

    private var shops : MutableList<Shop> = mutableListOf()
    private lateinit var  adapter : RecyclerShopAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}