package com.shela.janu.naufal.flashsmartairport.model

// Class ini hanya untuk menyimpan data sementara secara programatically

class DataStore {

  companion object {

      var FlightList : MutableList<Flight> = mutableListOf()
      val ShopList :  MutableList<Shop> = mutableListOf()
      val FacilityList : MutableList<Facility> = mutableListOf()
      val TransportList :  MutableList<Transportation> = mutableListOf()
      var titleNotify : String = ""
      var bodyNotify : String = ""
  }
}