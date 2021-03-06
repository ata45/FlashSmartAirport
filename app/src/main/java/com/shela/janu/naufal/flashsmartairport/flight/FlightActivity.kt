package com.shela.janu.naufal.flashsmartairport.flight

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.shela.janu.naufal.flashsmartairport.HomeActivity
import com.shela.janu.naufal.flashsmartairport.R
import kotlinx.android.synthetic.main.activity_flight.*
import org.jetbrains.anko.intentFor

class FlightActivity : AppCompatActivity() {


    private lateinit var pagerAdapter : FlightFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight)

        setSupportActionBar(toolbarFlight)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btm_flight_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.go_home -> {
                   startActivity(intentFor<HomeActivity>("select" to R.id.go_home))
                }
                R.id.go_myflight -> {
                    startActivity(intentFor<HomeActivity>("select" to R.id.go_myflight))
                }
                R.id.go_help -> {
                    startActivity(intentFor<HomeActivity>("select" to R.id.go_help))
                }
            }
            true
        }

        btn_back.setOnClickListener {

            startActivity(intentFor<HomeActivity>())
        }

        pagerAdapter = FlightFragmentAdapter(supportFragmentManager)
        viewPagerFlight.adapter = pagerAdapter
        tabFlight.setupWithViewPager(viewPagerFlight)
    }

    override fun onBackPressed() {
        startActivity(intentFor<HomeActivity>("select" to R.id.go_home))
    }

}
