package com.shela.janu.naufal.flashsmartairport.model

data class Flight (

    var idFlight : String? = null,
    var codeFlight : String? = null,
    var flightType : String? = null,
    var fromPlace : String?  = null,
    var toPlace : String ? = null,
    var planeName : String ? = null,
    var planeImage : Int ? = null,
    var departureTime : String? = null,
    var arriveTime : String? = null
)