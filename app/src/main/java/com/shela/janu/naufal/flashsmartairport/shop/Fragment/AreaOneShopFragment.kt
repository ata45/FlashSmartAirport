package com.shela.janu.naufal.flashsmartairport.shop.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.model.Shop
import com.shela.janu.naufal.flashsmartairport.shop.RecyclerShopAdapter
import com.shela.janu.naufal.flashsmartairport.shop.ShopDetailActivity
import kotlinx.android.synthetic.main.fragment_child_shop.*
import org.jetbrains.anko.support.v4.intentFor

class AreaOneShopFragment : Fragment() {

    private var foods: MutableList<Shop> = mutableListOf()
    private var souvenirs: MutableList<Shop> = mutableListOf()
    private lateinit var foodAdapter: RecyclerShopAdapter
    private lateinit var souvAdapter: RecyclerShopAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        foods.clear()
        souvenirs.clear()

        for (i in DataStore.ShopList) {
            if (i.areaSHop == "Area1") {
                when (i.typeShop) {
                    "Food" -> {
                        foods.add(i)
                    }
                    "Shop" -> {
                        souvenirs.add(i)
                    }
                }
            }
        }

        foodAdapter = RecyclerShopAdapter(this.context!!, foods) {

            DataStore.SHOP = it
            activity?.startActivity(intentFor<ShopDetailActivity>())
        }
        souvAdapter = RecyclerShopAdapter(this.context!!, souvenirs) {

            DataStore.SHOP = it
            activity?.startActivity(intentFor<ShopDetailActivity>())
        }


        rcy_shop_food.layoutManager = GridLayoutManager(activity, 2)
        rcy_shop_food.adapter = foodAdapter

        rcy_shop_souvenir.layoutManager = GridLayoutManager(activity, 2)
        rcy_shop_souvenir.adapter = souvAdapter


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child_shop, container, false)
    }
}