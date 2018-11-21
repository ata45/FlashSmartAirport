package com.shela.janu.naufal.flashsmartairport.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(
    ctx,
    "airport.db",
    null, 1
) {

    companion object {
        private var instance: DatabaseOpenHelper? = null
        @Synchronized
        fun getInstance(ctx: Context): DatabaseOpenHelper {
            if (instance == null) {
                instance = DatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as DatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            FlightSchedule.TABLE_FLIGHT, true,
            FlightSchedule.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FlightSchedule.ID_FLIGHT to TEXT + UNIQUE,
            FlightSchedule.CODE_FLIGHT to TEXT + UNIQUE,
            FlightSchedule.FLIGHT_TYPE to TEXT,
            FlightSchedule.FROM_PLACE to TEXT,
            FlightSchedule.TO_PLACE to TEXT,
            FlightSchedule.PLANE_NAME to TEXT,
            FlightSchedule.PLANE_IMAGE to TEXT,
            FlightSchedule.DEPART_TIME to TEXT,
            FlightSchedule.ARRIVE_TIME to TEXT
        )

        db?.createTable(
            LostAndFound.TABLE_LOST, true,
            LostAndFound.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            LostAndFound.REPORT_NAME to TEXT,
            LostAndFound.OWNER_NAME to TEXT,
            LostAndFound.PHONE_NUMBER to TEXT,
            LostAndFound.ADDRESS to TEXT,
            LostAndFound.POSTAL_CODE to TEXT,
            LostAndFound.DATE_OF_LOSS to TEXT,
            LostAndFound.TIME_OF_LOSS to TEXT,
            LostAndFound.ITEM_TYPE to TEXT,
            LostAndFound.DETAIL_ITEM to TEXT,
            LostAndFound.CHRONOLOGY to TEXT,
            LostAndFound.IMAGE_LOST to BLOB
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(FlightSchedule.TABLE_FLIGHT, true)
        db?.dropTable(LostAndFound.TABLE_LOST, true)
    }
}

val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstance(applicationContext)