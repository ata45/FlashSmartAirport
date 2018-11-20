package com.shela.janu.naufal.flashsmartairport.facility

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.shela.janu.naufal.flashsmartairport.HomeActivity
import com.shela.janu.naufal.flashsmartairport.R
import kotlinx.android.synthetic.main.activity_facility.*
import org.jetbrains.anko.intentFor

class FacilityActivity : AppCompatActivity() {

    private lateinit var pagerAdapter : FacilityFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facility)

        setSupportActionBar(toolbarFacilities)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btm_facility_nav.setOnNavigationItemSelectedListener { item ->
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

        pagerAdapter = FacilityFragmentAdapter(supportFragmentManager)
        viewPagerFacilities.adapter = pagerAdapter
        tabFacilities.setupWithViewPager(viewPagerFacilities)
    }

    override fun onKeyShortcut(keyCode: Int, event: KeyEvent?): Boolean {
        if( keyCode == KeyEvent.KEYCODE_BACK )
        {
            startActivity(intentFor<HomeActivity>("select" to R.id.go_home))
            return true
        }

        return false
    }
}
