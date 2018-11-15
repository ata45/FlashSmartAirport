package com.shela.janu.naufal.flashsmartairport

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shela.janu.naufal.flashsmartairport.model.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initiateData()


    }

    private fun initiateData() {

        progress_circular.visibility = View.VISIBLE

        DataStore.FacilityList.clear()
        DataStore.FlightList.clear()
        DataStore.ShopList.clear()
        DataStore.TransportList.clear()

        fetchDataFlight()
        fetchDataShop()
        fetchDataTransport()
        fetchDataFacility()

        progress_circular.visibility = View.INVISIBLE

    }

    private fun LoadHomeFragment(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, HomeFragment(), HomeFragment::class.simpleName)
                .commit()
        }
    }

    private fun LoadMyFlightFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_container,
                    MyFlightFragment(), MyFlightFragment::class.simpleName
                )
                .commit()
        }
    }

    private fun LoadHelpFragment(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, HomeFragment(), HomeFragment::class.simpleName)
                .commit()
        }
    }



    private fun fetchDataFlight() {

        val flight1 = Flight("1", "4001", "departure", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight2 = Flight("2", "4002", "departure", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight3 = Flight("3", "4003", "departure", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight4 = Flight("4", "4004", "departure", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight5 = Flight("5", "4005", "departure", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight6 = Flight("6", "4006", "arrive", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight7 = Flight("7", "4007", "arrive", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight8 = Flight("8", "4008", "arrive", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight9 = Flight("9", "4009", "arrive", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")
        val flight10 = Flight("10", "4010", "arrive", "SBY", "JKT", "Garuda Indonesia", "", "07:00", "08:30")

        DataStore.FlightList.add(flight1)
        DataStore.FlightList.add(flight2)
        DataStore.FlightList.add(flight3)
        DataStore.FlightList.add(flight4)
        DataStore.FlightList.add(flight5)
        DataStore.FlightList.add(flight6)
        DataStore.FlightList.add(flight7)
        DataStore.FlightList.add(flight8)
        DataStore.FlightList.add(flight9)
        DataStore.FlightList.add(flight10)

    }

    private fun fetchDataShop() {

        val shop1 = Shop("1", "Izakaya", "Area1", "Restorant", 4, "081212121", "", "", "Warung")
        val shop2 = Shop("2", "Izakaya", "Area1", "Restorant", 5, "081212121", "", "", "Warung")
        val shop3 = Shop("3", "Izakaya", "Area1", "Restorant", 4, "081212121", "", "", "Warung")
        val shop4 = Shop("4", "Izakaya", "Area2", "Restorant", 3, "081212121", "", "", "Warung")
        val shop5 = Shop("5", "Izakaya", "Area2", "Restorant", 4, "081212121", "", "", "Warung")
        val shop6 = Shop("6", "Izakaya", "Area2", "Restorant", 5, "081212121", "", "", "Warung")
        val shop7 = Shop("7", "Izakaya", "Area3", "Restorant", 3, "081212121", "", "", "Warung")
        val shop8 = Shop("8", "Izakaya", "Area3", "Restorant", 5, "081212121", "", "", "Warung")
        val shop9 = Shop("9", "Izakaya", "Area3", "Restorant", 4, "081212121", "", "", "Warung")

        DataStore.ShopList.add(shop1)
        DataStore.ShopList.add(shop2)
        DataStore.ShopList.add(shop3)
        DataStore.ShopList.add(shop4)
        DataStore.ShopList.add(shop5)
        DataStore.ShopList.add(shop6)
        DataStore.ShopList.add(shop7)
        DataStore.ShopList.add(shop8)
        DataStore.ShopList.add(shop9)

    }

    private fun fetchDataFacility() {

        val facility1 = Facility("1", "", "", "", "Area1")
        val facility2 = Facility("2", "", "", "", "Area1")
        val facility3 = Facility("3", "", "", "", "Area1")
        val facility4 = Facility("4", "", "", "", "Area2")
        val facility5 = Facility("5", "", "", "", "Area2")
        val facility6 = Facility("6", "", "", "", "Area2")
        val facility7 = Facility("7", "", "", "", "Area3")
        val facility8 = Facility("8", "", "", "", "Area3")
        val facility9 = Facility("9", "", "", "", "Area3")

        DataStore.FacilityList.add(facility1)
        DataStore.FacilityList.add(facility2)
        DataStore.FacilityList.add(facility3)
        DataStore.FacilityList.add(facility4)
        DataStore.FacilityList.add(facility5)
        DataStore.FacilityList.add(facility6)
        DataStore.FacilityList.add(facility7)
        DataStore.FacilityList.add(facility8)
        DataStore.FacilityList.add(facility9)


    }

    private fun fetchDataTransport() {

        val transport1 = Transportation("1","BMW", "Travel", "","", "")
        val transport2 = Transportation("2","BMW", "Travel", "","", "")
        val transport3 = Transportation("3","BMW", "Travel", "","", "")
        val transport4 = Transportation("4","BMW", "Rent", "","", "")
        val transport5 = Transportation("5","BMW", "Rent", "","", "")
        val transport6 = Transportation("6","BMW", "Rent", "","", "")
        val transport7 = Transportation("7","BMW", "Shuttle", "","", "")
        val transport8 = Transportation("8","BMW", "Shuttle", "","", "")
        val transport9 = Transportation("9","BMW", "Shuttle", "","", "")

        DataStore.TransportList.add(transport1)
        DataStore.TransportList.add(transport2)
        DataStore.TransportList.add(transport3)
        DataStore.TransportList.add(transport4)
        DataStore.TransportList.add(transport5)
        DataStore.TransportList.add(transport6)
        DataStore.TransportList.add(transport7)
        DataStore.TransportList.add(transport8)
        DataStore.TransportList.add(transport9)

    }

}
