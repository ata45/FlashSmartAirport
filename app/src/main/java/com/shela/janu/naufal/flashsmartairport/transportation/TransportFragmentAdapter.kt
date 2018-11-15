package com.shela.janu.naufal.flashsmartairport.transportation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AllFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaOneFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaThreeFacilityFragment
import com.shela.janu.naufal.flashsmartairport.facility.Fragment.AreaTwoFacilityFragment
import com.shela.janu.naufal.flashsmartairport.transportation.Fragment.RentFragment
import com.shela.janu.naufal.flashsmartairport.transportation.Fragment.ShuttleFragment
import com.shela.janu.naufal.flashsmartairport.transportation.Fragment.TravelFragment

class TransportFragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val count = 3

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {

            0 -> fragment = TravelFragment()
            1 -> fragment = RentFragment()
            2 -> fragment = ShuttleFragment()
        }
        return fragment
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Travel Car"
            1 -> "Rent Car"
            else -> "Shuttle Bus"
        }
    }
    override fun getCount(): Int {
        return count
    }

}