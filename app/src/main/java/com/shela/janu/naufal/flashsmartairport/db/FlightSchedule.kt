package com.shela.janu.naufal.flashsmartairport.db

class FlightSchedule(

    var id : Long? = null,
    var idFlight : String? = null,
    var codeFlight : String? = null,
    var flightType : String? = null,
    var fromPlace : String?  = null,
    var toPlace : String ? = null,
    var planeName : String ? = null,
    var planeImage : String ? = null,
    var departTime : String? = null,
    var arriveTime : String? = null
) {
    companion object {

        const val TABLE_FLIGHT : String = "TABLE_FLIGHT"
        const val ID : String = "ID_"
        const val ID_FLIGHT : String = "ID_FLIGHT"
        const val CODE_FLIGHT : String = "CODE_FLIGHT"
        const val FLIGHT_TYPE : String = "FLIGHT_TYPE"
        const val FROM_PLACE : String = "FROM_PLACE"
        const val TO_PLACE : String = "TO_PLACE"
        const val PLANE_NAME : String = "PLANE_NAME"
        const val PLANE_IMAGE : String = "PLANE_IMAGE"
        const val DEPART_TIME : String = "DEPART_TIME"
        const val ARRIVE_TIME : String = "ARRIVE_TIME"
    }
}