package com.shela.janu.naufal.flashsmartairport.shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.shela.janu.naufal.flashsmartairport.R
import com.shela.janu.naufal.flashsmartairport.model.DataStore
import com.shela.janu.naufal.flashsmartairport.model.Shop
import kotlinx.android.synthetic.main.activity_shop_detail.*

class ShopDetailActivity : AppCompatActivity() {

    private var isPressed : Boolean = false


    private  lateinit var  shop : Shop
    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)

        shop = DataStore.SHOP

        shop.imageShop?.let { Glide.with(this).load(it).into(image_atm_centre) }

        shop_desc.text = shop.descShop
        shop_contact.text = shop.contactShop
        shop_location.text = shop.areaSHop
        shop_time_run.text = shop.timeShop
        shop_method_payment.text = shop.methodPayment
        shop_range_price.text = shop.rangePrice
        shop_money_type.text = shop.moneyType

        btn_show_shop.setOnClickListener {
            count++
            isPressed = count % 2 != 0
            showDetail()
        }

        btn_back.setOnClickListener {
            finish()
        }
    }

    private fun showDetail(){

        if(isPressed){
            parent_text_detail.visibility = View.VISIBLE
        }

        else{
            parent_text_detail.visibility = View.INVISIBLE
        }
    }
}
