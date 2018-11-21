package com.shela.janu.naufal.flashsmartairport.help

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shela.janu.naufal.flashsmartairport.flight.Fragment.ArrivalFragment
import com.shela.janu.naufal.flashsmartairport.flight.Fragment.DepartureFragment

class HelpFragmentAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val count = 2

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment = MainHelpFragment()
            1 -> fragment = LostItemListFragment()
        }
        return fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Help"
            else -> "Items Lost and Found"
        }
    }
    override fun getCount(): Int {
        return count
    }
}