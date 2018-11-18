package com.shela.janu.naufal.flashsmartairport.shop

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.Shop
import kotlinx.android.synthetic.main.card_shops.view.*

class RecyclerShopAdapter(private val context : Context, private val shops : List <Shop>,
                          private val listener : (Shop) -> Unit) :
    RecyclerView.Adapter<RecyclerShopAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_shops, p0, false))
    }

    override fun getItemCount(): Int {
       return shops.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.bindItems(shops[p1], context, listener)
    }

    class ViewHolder(private val containerView : View) : RecyclerView.ViewHolder(containerView){

        @SuppressLint("SetTextI18n")
        fun bindItems(shop : Shop, context: Context, listener: (Shop) -> Unit){

            containerView.textShopTitle.text = shop.nameShop
            containerView.textShopInfo.text = shop.areaSHop + ", " + shop.contactShop
            shop.imageShop?.let { Glide.with(context).load(it).into(containerView.imageShopResto) }
            containerView.setOnClickListener { listener(shop) }
        }
    }
}