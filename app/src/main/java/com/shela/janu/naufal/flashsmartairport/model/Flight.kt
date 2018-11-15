package com.shela.janu.naufal.flashsmartairport.model

data class Flight (
    var idFlight : String? = null,
    var codeFlight : String? = null,
    var flightType : String? = null,
    var fromDepart : String?  = null,
    var toArrive : String ? = null,
    var planeName : String ? = null,
    var planeImage : String ? = null,
    var departureTime : String? = null,
    var arriveTime : String? = null
)