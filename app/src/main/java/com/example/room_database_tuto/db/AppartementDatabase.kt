package com.example.room_database_tuto.db



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_database_tuto.dao.AppartementDao
import com.example.room_database_tuto.model.Appartement

@Database(entities = [Appartement::class], version = AppartementDatabase.DB_VERSION)
abstract class AppartementDatabase: RoomDatabase(){




    abstract fun appartementDao(): AppartementDao

    companion object {
        const val DB_VERSION = 2
        const val TABLE_APPARTEMENTS_NAME = "appatements_table"
        const val APPARTEMENT_DB_NAME = "appatement_db"
        const val ID_COLUMN_NAME = "_id"
        const val OFFER_COLUMN_NAME = "_offer"
        const val PARKING_COLUMN_NAME = "_avec_parking"
        const val SURFACE_COLUMN_NAME = "_surface"
        const val IMG_COLUMN_NAME = "_img"

        private var instance: AppartementDatabase? = null
        private val LOCK = Any()
        fun getInstance(context: Context): AppartementDatabase {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppartementDatabase::class.java, APPARTEMENT_DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance as AppartementDatabase
            }
        }

        fun getInstance2(context: Context): AppartementDatabase {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppartementDatabase::class.java, APPARTEMENT_DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance as AppartementDatabase
            }
        }


    }
}


