package com.shela.janu.naufal.flashsmartairport.transportation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentPagerAdapter
import com.shela.janu.naufal.flashsmartairport.HomeActivity
import com.shela.janu.naufal.flashsmartairport.R
import kotlinx.android.synthetic.main.activity_transport.*
import org.jetbrains.anko.intentFor

class TransportActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: TransportFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transport)

        btm_transport_nav.setOnNavigationItemSelectedListener { item ->
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

        pagerAdapter = TransportFragmentAdapter(supportFragmentManager)
        viewPagerTransport.adapter = pagerAdapter
        tabTransport.setupWithViewPager(viewPagerTransport)

    }
}
