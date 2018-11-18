package com.shela.janu.naufal.flashsmartairport.facility

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaOneFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaThreeFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaTwoFacilityFragment

class FacilityFragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val count = 3

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment =AreaOneFacilityFragment()
            1 -> fragment = AreaTwoFacilityFragment()
            2 -> fragment = AreaThreeFacilityFragment()
        }

        return fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Terminal 1"
            1 -> "Terminal 2"
            else -> "Terminal 3"
        }
    }
    override fun getCount(): Int {
        return count
    }

}