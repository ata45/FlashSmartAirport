package com.shela.janu.naufal.flashsmartairport.shop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.shela.janu.naufal.flashsmartairport.HomeActivity
import com.shela.janu.naufal.flashsmartairport.R
import kotlinx.android.synthetic.main.activity_shop.*
import org.jetbrains.anko.intentFor

class ShopActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: ShopFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        setSupportActionBar(toolbarShop)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btm_shop_nav.setOnNavigationItemSelectedListener { item ->
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

        pagerAdapter = ShopFragmentAdapter(supportFragmentManager)
        viewPagerShop.adapter = pagerAdapter
        tabShop.setupWithViewPager(viewPagerShop)
    }

    override fun onBackPressed() {
        startActivity(intentFor<HomeActivity>("select" to R.id.go_home))
    }

}
