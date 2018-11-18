package com.shela.janu.naufal.flashsmartairport

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_maps.*
import org.jetbrains.anko.intentFor

class MapsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        btm_nav_maps.setOnNavigationItemSelectedListener { item ->
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

    }
}
