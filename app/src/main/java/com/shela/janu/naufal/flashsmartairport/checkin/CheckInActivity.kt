package com.shela.janu.naufal.flashsmartairport.checkin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shela.janu.naufal.flashsmartairport.HomeActivity
import com.shela.janu.naufal.flashsmartairport.R
import kotlinx.android.synthetic.main.activity_check_in.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.intentFor

class CheckInActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)

        card_air_asia.setOnClickListener {
            browse("https://checkin.airasia.com")
        }
        card_batik.setOnClickListener {
            browse("https://www.batikair.com/en/Checkin")
        }
        card_citilink.setOnClickListener {
            browse("https://book.citilink.co.id/searchwebcheckin.aspx")
        }
        card_garuda.setOnClickListener {
            browse("https://www.garuda-indonesia.com/id/id/garuda-indonesia-experience/on-ground/check-in/index.page")
        }
        card_singapore.setOnClickListener {
            browse("https://www.singaporeair.com/en_UK/plan-and-book/your-booking/checkin/")
        }
        card_lion.setOnClickListener {
            browse("http://www.lionair.co.id/booking-and-services/web-check-in")
        }
        btn_back.setOnClickListener {
            startActivity(intentFor<HomeActivity>())
        }
    }

    override fun onBackPressed() {
        startActivity(intentFor<HomeActivity>("select" to R.id.go_home))
    }



}
