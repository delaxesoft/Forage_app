package com.example.forageapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forageapp.model.Forageable

@Database(entities=[Forageable::class], version=1, exportSchema = false )
abstract class ForageDatabase: RoomDatabase() {

    abstract fun forageableDao(): ForageableDao

    companion object {
        @Volatile
        private var INSTANCE: ForageDatabase? = null

        fun getDatabase(context: Context): ForageDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ForageDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}