package com.shela.janu.naufal.flashsmartairport.shop

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shela.janu.naufal.flashsmartairport.shop.Fragment.AllShopFragment
import com.shela.janu.naufal.flashsmartairport.shop.Fragment.AreaOneShopFragment
import com.shela.janu.naufal.flashsmartairport.shop.Fragment.AreaThreeShopFragment
import com.shela.janu.naufal.flashsmartairport.shop.Fragment.AreaTwoShopFragment

class ShopFragmentAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val count = 4

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment = AllShopFragment()
            1 -> fragment = AreaOneShopFragment()
            2 -> fragment = AreaTwoShopFragment()
            3 -> fragment = AreaThreeShopFragment()
        }
        return fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "All"
            1 -> "Area 1"
            2 -> "Area 2"
            else ->  "Area 3"
        }
    }
    override fun getCount(): Int {
        return count
    }

}