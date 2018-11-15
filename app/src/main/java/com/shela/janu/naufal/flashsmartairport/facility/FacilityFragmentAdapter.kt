package com.shela.janu.naufal.flashsmartairport.facility

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AllFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaOneFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaThreeFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaTwoFacilityFragment

class FacilityFragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val count = 4

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment = AllFacilityFragment()
            1 -> fragment = AreaOneFacilityFragment()
            2 -> fragment = AreaTwoFacilityFragment()
            3 -> fragment = AreaThreeFacilityFragment()
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