package com.example.room_database_tuto.repositry

import androidx.room.Insert
import com.example.room_database_tuto.db.AppartementDatabase
import com.example.room_database_tuto.model.Appartement
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val db: AppartementDatabase) {

    private val appartementDao = db.appartementDao()


    fun getAll(): Flow<List<Appartement>> {
        return appartementDao.getAll()
    }

    suspend fun insertAll(appartement: Appartement) {
        appartementDao.insertAll(appartement)
    }

    suspend fun delete(appartement: Appartement) {
        appartementDao.delete(appartement)
    }

    fun loadAllByIds(userId: Int): Flow<List<Appartement>> {
        return appartementDao.loadAllByIds(userId)
    }

}