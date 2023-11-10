package com.example.room_database_tuto.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.room_database_tuto.db.AppartementDatabase
import com.example.room_database_tuto.model.Appartement
import kotlinx.coroutines.flow.Flow

@Dao
interface AppartementDao {
    @Query("SELECT * FROM ${AppartementDatabase.TABLE_APPARTEMENTS_NAME}")
    fun getAll(): Flow<List<Appartement>>

    @Query("SELECT * FROM ${AppartementDatabase.TABLE_APPARTEMENTS_NAME} WHERE ${AppartementDatabase.ID_COLUMN_NAME} IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Flow<List<Appartement>>

    @Insert
    suspend fun insertAll(appartement: Appartement)

    @Delete
    suspend fun delete(appartement: Appartement)
}

