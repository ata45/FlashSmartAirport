package com.shela.janu.naufal.flashsmartairport.db

import java.sql.Blob

class LostAndFound(
    val reportName : String?,
    val ownerName  : String?,
    val phoneNumber : String?,
    val address : String?,
    val postalCode : String?,
    val dateOfLoss : String?,
    val timeofLoss : String?,
    val itemType : String?,
    val detailItem : String?,
    val chronologyOfLost : String?,
    val imageLost : Blob?

){

    companion object {

        const val TABLE_LOST: String = "TABLE_LOST"
        const val ID: String = "ID_"
        const val REPORT_NAME: String = " REPORT_NAME"
        const val OWNER_NAME: String = "OWNER_NAME"
        const val PHONE_NUMBER: String = "PHONE_NUMBER"
        const val ADDRESS: String = "ADDRESS"
        const val POSTAL_CODE: String = "POSTAL_CODE"
        const val DATE_OF_LOSS: String = "DATE_OF_LOSS"
        const val TIME_OF_LOSS: String = "TIME_OF_LOSS"
        const val ITEM_TYPE: String = "ITEM_TYPE"
        const val DETAIL_ITEM: String = "DETAIL_ITEM"
        const val CHRONOLOGY: String = "CHRONOLOGY"
        const val IMAGE_LOST: String = "IMAGE_LOST"
    }
}
