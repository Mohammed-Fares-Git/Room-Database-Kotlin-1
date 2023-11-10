package com.example.room_database_tuto.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room_database_tuto.db.AppartementDatabase

@Entity(tableName = AppartementDatabase.TABLE_APPARTEMENTS_NAME)
data class Appartement (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = AppartementDatabase.ID_COLUMN_NAME)
    val id: Int,
    @ColumnInfo(name = AppartementDatabase.OFFER_COLUMN_NAME) val offer: String,
    @ColumnInfo(name = AppartementDatabase.SURFACE_COLUMN_NAME) val surface: Int,
    @ColumnInfo(name = AppartementDatabase.PARKING_COLUMN_NAME) val avecParking: Boolean,
    @ColumnInfo(name = AppartementDatabase.IMG_COLUMN_NAME) val image: String
    )
