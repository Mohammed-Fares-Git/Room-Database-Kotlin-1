package com.example.room_database_tuto.db

import androidx.room.Database
import com.example.room_database_tuto.dao.AppartementDao
import com.example.room_database_tuto.model.Appartement

@Database(entities = [Appartement::class], version = AppartementDatabase.DB_VERSION)
abstract class AppartementDatabase {

    abstract fun appartementDao(): AppartementDao

    companion object {
        const val DB_VERSION = 1
        const val ADD_MESSAGE = "lala nadu !"
        const val TABLE_APPARTEMENTS_NAME = "appatements_table"
        const val ID_COLUMN_NAME = "_id"
        const val OFFER_COLUMN_NAME = "_offer"
        const val PARKING_COLUMN_NAME = "_avec_parking"
        const val SURFACE_COLUMN_NAME = "_surface"
        const val IMG_COLUMN_NAME = "_img"
    }
}