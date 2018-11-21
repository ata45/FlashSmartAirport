package com.shela.janu.naufal.flashsmartairport

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shela.janu.naufal.flashsmartairport.help.HelpFragment
import com.shela.janu.naufal.flashsmartairport.model.*
import com.shela.janu.naufal.flashsmartairport.services.NotificationUtils
import kotlinx.android.synthetic.main.activity_home.*
import java.text.SimpleDateFormat
import java.util.*

class HomeActivity : AppCompatActivity() {


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initiateData()
        val id = intent.getIntExtra("select", R.id.go_home)

        btm_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.go_home -> {
                    loadHomeFragment(savedInstanceState)
                }
                R.id.go_myflight -> {
                    loadMyFlightFragment(savedInstanceState)
                }
                R.id.go_help -> {
                    loadHelpFragment(savedInstanceState)
                }
            }

            true
        }
        btm_nav.selectedItemId = id


        // Method untuk memuat semua data yang dibutuhkan, karena tidak disediakan API maka dibuat manual


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

    private fun loadHomeFragment(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, HomeFragment(), HomeFragment::class.java.simpleName)
                .commitAllowingStateLoss()
        }
    }

    private fun loadMyFlightFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.main_container,
                    MyFlightFragment(), MyFlightFragment()::class.java.simpleName
                )
                .commitAllowingStateLoss()
        }
    }

    private fun loadHelpFragment(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, HelpFragment(), HelpFragment::class.java.simpleName)
                .commitAllowingStateLoss()
        }
    }


    @SuppressLint("ResourceType")
    private fun fetchDataFlight() {

        val image = resources.obtainTypedArray(R.array.plane_image)

        val flight1 = Flight(
            "1",
            "4001",
            "departure",
            "SBY",
            "JKT",
            "Garuda Indonesia",
            image.getResourceId(0, 0),
            "07:00",
            "08:30"
        )
        val flight2 =
            Flight("2", "4002", "departure", "SBY", "ARAB", "Fly Emirates", image.getResourceId(2, 0), "08:00", "09:30")
        val flight3 =
            Flight("3", "4003", "departure", "SBY", "JFK", "Lion Air", image.getResourceId(1, 0), "08:30", "09:30")
        val flight4 = Flight(
            "4",
            "4004",
            "departure",
            "SBY",
            "ACEH",
            "Garuda Indonesia",
            image.getResourceId(0, 0),
            "10:00",
            "11:30"
        )
        val flight5 = Flight(
            "5",
            "4005",
            "departure",
            "SBY",
            "MESIR",
            "Fly Emirates",
            image.getResourceId(2, 0),
            "13:00",
            "14:30"
        )
        val flight6 =
            Flight("6", "4006", "arrive", "ACEH", "BDG", "Garuda Indonesia", image.getResourceId(0, 0), "07:00", "08:30")
        val flight7 =
            Flight("7", "4007", "arrive", "SBY", "BDG", "Garuda Indonesia", image.getResourceId(0, 0), "08:00", "09:30")
        val flight8 =
            Flight("8", "4008", "arrive", "JKT", "BDG", "Lion Air", image.getResourceId(1, 0), "09:00", "10:30")
        val flight9 =
            Flight("9", "4009", "arrive", "MESIR", "BDG", "Ethad Airways", image.getResourceId(3, 0), "07:00", "08:30")
        val flight10 =
            Flight("10", "4010", "arrive", "ARAB", "BDG", "Ethad Airways", image.getResourceId(3, 0), "07:00", "08:30")

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

        image.recycle()


    }

    @SuppressLint("ResourceType")
    private fun fetchDataShop() {

        val image = resources.obtainTypedArray(R.array.image_shop)

        val shop1 = Shop(
            "1",
            "Alfa mart",
            "Terminal 1",
            "Shop",
            4,
            "081212129",
            image.getResourceId(0, 0),
            "",
            "Alfa mart menjual berbagai keperluan engan harga terjangkau, tersedia di Terminal 1 dekat ATM Center",
            25,
            "04.00 - 24.00",
            "Rp 500 - Rp.100.000",
            "Cash, Debit",
            "Rupiah, US Dollar"
        )
        val shop2 = Shop(
            "2",
            "Geprek bensu",
            "Terminal 1",
            "Food",
            5,
            "081312128",
            image.getResourceId(1, 0),
            "",
            "Geprek Bensu menjual ayam geprek dengan level kepedasan yang berbeda, terdapat pada Terminal 1",
            100,
            "07.00 - 21.00",
            "Rp. 15.000 - Rp. 50.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro"
        )
        val shop3 = Shop(
            "3",
            "Chatime",
            "Terminal 1",
            "Food",
            4,
            "081412127",
            image.getResourceId(2, 0),
            "",
            "Chatime menjual minuman susu kocok aneka rasa dengan campuran berbagai bahan, terdapat pada terminal 1",
            38,
            "07.00 - 23.00",
            "Rp. 20.000 - Rp. 70.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro"
        )
        val shop4 = Shop(
            "4",
            "Garuda Souvenir",
            "Terminal 1",
            "Shop",
            3,
            "081512126",
            image.getResourceId(3, 0),
            "",
            "Garuda Souvenir menjual berbgai souvenir khas indonesia",
            62,
            "04.00 - 21.00",
            "Rp. 50.000 - Rp. 1.000.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro, Yen"
        )
        val shop5 = Shop(
            "5",
            "Giant",
            "Terminal 2",
            "Shop",
            4,
            "081612125",
            image.getResourceId(4, 0),
            "",
            "Toko serba ada dengan harga terjangkau, terdapat di Terminal 2",
            67,
            "05.00 - 23.00",
            "Rp. 1000 - Rp. 200.000",
            "Cash, Debit",
            "Rupiah, US Dollar"
        )
        val shop6 = Shop(
            "6",
            "Indomaret",
            "Terminal 2",
            "Shop",
            5,
            "081712124",
            image.getResourceId(5, 0),
            "",
            "Toko serba ada buka 24 jam dengan harga terjangkau",
            49,
            "00.00 - 23.59",
            "Rp. 1000 - Rp 150.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro"
        )
        val shop7 = Shop(
            "7",
            "Izakaya",
            "Terminal 2",
            "Food",
            3,
            "081812123",
            image.getResourceId(6, 0),
            "",
            "Restoran Jepang cepat saji dengan makanan khas tradisional jepang",
            91,
            "06.00 - 22.00",
            "Rp. 15.000 - Rp. 100.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Yen"
        )
        val shop8 = Shop(
            "8",
            "KFC",
            "Terminal 2",
            "Food",
            5,
            "081912122",
            image.getResourceId(7, 0),
            "",
            "Restoran Cepat saji menyajikan Ayam Goreng dan makanan Fastfood lain nya",
            20,
            "00.00 - 23.59",
            "Rp. 15.000 -  Rp. 90.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro, Yen, Ringgit"
        )
        val shop9 = Shop(
            "9",
            "MCD",
            "Terminal 3",
            "Food",
            4,
            "081222121",
            image.getResourceId(8, 0),
            "",
            "Restoran Cepat saji menyajikan berbagai makanan amerika atau junk food",
            51,
            "03.00 - 22.00",
            "Rp. 20.000 - Rp. 150.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro"
        )
        val shop10 = Shop(
            "10",
            "Miniso",
            "Terminal 3",
            "Shop",
            4,
            "081222121",
            image.getResourceId(9, 0),
            "",
            "Toko yang menjual berbagai alat dan perkakas khas dari Asia timur",
            51,
            "08.00 - 23.59",
            "Rp 50.000 - Rp 300.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Yen"
        )
        val shop11 = Shop(
            "11",
            "Richeese",
            "Terminal 3",
            "Food",
            4,
            "081222121",
            image.getResourceId(10, 0),
            "",
            "Restoran Cepat saji menyajikan makanan dengan serba Keju",
            51,
            "05.00 - 22.00",
            "Rp 30.000 - Rp 100.000",
            "Cash, Debit",
            "Rupiah, US Dollar, Euro"
        )
        val shop12 = Shop(
            "12",
            "Souvenir",
            "Terminal 3",
            "Shop",
            4,
            "081222121",
            image.getResourceId(11, 0),
            "",
            "Toko menjual souvenir dari seluruh manca negara degan kualitas tinggi",
            51,
            "09.00 - 23.00",
            "Rp 50.000 - Rp 2.000.000",
            "Cash, Debit",
            "Dollar, Rupiah, Euro, Yen"
        )



        DataStore.ShopList.add(shop1)
        DataStore.ShopList.add(shop2)
        DataStore.ShopList.add(shop3)
        DataStore.ShopList.add(shop4)
        DataStore.ShopList.add(shop5)
        DataStore.ShopList.add(shop6)
        DataStore.ShopList.add(shop7)
        DataStore.ShopList.add(shop8)
        DataStore.ShopList.add(shop9)
        DataStore.ShopList.add(shop10)
        DataStore.ShopList.add(shop11)
        DataStore.ShopList.add(shop12)

        image.recycle()

    }

    @SuppressLint("ResourceType")
    private fun fetchDataFacility() {

        val image = resources.obtainTypedArray(R.array.facilities)

        val facility1 =
            Facility("1", "Air Port Lounge T1", "Tempat tunggu pesawat Terminal 1", "Terminal 1", image.getResourceId(0, 0))
        val facility2 =
            Facility("2", "Air Port Lounge T2", "Tempat tunggu pesawat Terminal 2", "Terminal 2", image.getResourceId(1, 0))
        val facility3 = Facility(
            "3",
            "Airport Mosque",
            "Masjid At-Taqwa besar bandara Kertajati",
            "Terminal 2",
            image.getResourceId(2, 0)
        )
        val facility4 =
            Facility("4", "Kids Corner T1", "Tempat bermain anak Terminal 1", "Terminal 1", image.getResourceId(3, 0))
        val facility5 =
            Facility("5", "Kids Corner T3", "Tempat bermain anak Terminal 2", "Terminal 3", image.getResourceId(4, 0))
        val facility6 = Facility(
            "6",
            "Money Charger T2",
            "Tempat penukaran mata uang Terminal 2",
            "Terminal 2",
            image.getResourceId(5, 0)
        )
        val facility7 = Facility(
            "7",
            "Money Charger T3",
            "Tempat pertukaran mata uang Terminal 3",
            "Terminal 3",
            image.getResourceId(6, 0)
        )
        val facility8 =
            Facility("8", "Airport Mushola", "Mushola Al-Ikhlas bandara Kertajati", "Terminal 1", image.getResourceId(7, 0))
        val facility9 = Facility("9", "Main Toilet Airport", "Toilet utama bandara", "Terminal 3", image.getResourceId(8, 0))
        val facility10 =
            Facility("10", "ATM Centre T1", "ATM semua tipe kartu Terminal 1", "Terminal 1", image.getResourceId(9, 0))
        val facility11 =
            Facility("11", "ATM centre T3", "ATM semua tipe kartu Terminal 2", "Terminal 3", image.getResourceId(10, 0))
        val facility12 = Facility(
            "12",
            "Airport Hotel T2",
            "Hotel bandara kertajati Terminal 2",
            "Terminal 2",
            image.getResourceId(11, 0)
        )



        DataStore.FacilityList.add(facility1)
        DataStore.FacilityList.add(facility2)
        DataStore.FacilityList.add(facility3)
        DataStore.FacilityList.add(facility4)
        DataStore.FacilityList.add(facility5)
        DataStore.FacilityList.add(facility6)
        DataStore.FacilityList.add(facility7)
        DataStore.FacilityList.add(facility8)
        DataStore.FacilityList.add(facility9)
        DataStore.FacilityList.add(facility10)
        DataStore.FacilityList.add(facility11)
        DataStore.FacilityList.add(facility12)

        image.recycle()


    }

    @SuppressLint("ResourceType")
    private fun fetchDataTransport() {

        val image = resources.obtainTypedArray(R.array.transport_image)

        val transport1 = Transportation(
            "1",
            "Bus CT",
            "Travel",
            "Travel kelas 1 tujuan bandara Kertajati",
            image.getResourceId(0, 0),
            "04.00 - 22.00"
        )
        val transport2 = Transportation(
            "2",
            "Bus DMR",
            "Travel",
            "Travel kelas 2 tujuan bandara Kertajati",
            image.getResourceId(1, 0),
            "06.00 - 24.00"
        )
        val transport3 = Transportation(
            "3",
            "Bus FDR",
            "Travel",
            "Travel kelas 3 tujuan bandara Kertajati",
            image.getResourceId(2, 0),
            "08.00 - 20.00"
        )
        val transport4 = Transportation(
            "4",
            "Bus LNDN",
            "Rent",
            "Menyewakan untuk rombongan tujuan bandara Kertajati",
            image.getResourceId(3, 0),
            "Tentati, maksimal seminggu"
        )
        val transport5 = Transportation(
            "5",
            "Bus MT",
            "Rent",
            "Menyewakan  untuk rombongan tujuan bandara Kertajati",
            image.getResourceId(4, 0),
            "Tentatif, maksimal seminggu"
        )
        val transport6 = Transportation(
            "6",
            "Blue Bird",
            "Rent",
            "Menyewakan untuk sekeluarga tujuan bandara Kertajati",
            image.getResourceId(5, 0),
            "Tentatif, maksimal 5 hari"
        )
        val transport7 = Transportation(
            "7",
            "Bus Tingkat",
            "Shuttle",
            "Angkutan umum  Kertajati Area 1",
            image.getResourceId(6, 0),
            "05.00 - 23.00"
        )
        val transport8 = Transportation(
            "8",
            "Bus TJ",
            "Shuttle",
            "Angkutan umum  Kertajati Area 2",
            image.getResourceId(7, 0),
            "04.00 - 23.00"
        )
        val transport9 = Transportation(
            "9",
            "Bus MTR",
            "Shuttle",
            "Angkutan umum  Kertajati Area 3",
            image.getResourceId(8, 0),
            "06.00 - 23.00"
        )



        DataStore.TransportList.add(transport1)
        DataStore.TransportList.add(transport2)
        DataStore.TransportList.add(transport3)
        DataStore.TransportList.add(transport4)
        DataStore.TransportList.add(transport5)
        DataStore.TransportList.add(transport6)
        DataStore.TransportList.add(transport7)
        DataStore.TransportList.add(transport8)
        DataStore.TransportList.add(transport9)

        image.recycle()


    }

}
