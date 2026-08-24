package com.abdullojon.lugatapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database([Dictionary::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    companion object{
        @Volatile
        private lateinit var INSTANCE: MyDatabase
        const val MY_DATABASE="dictionary.db"

        fun init(context: Context){
            if (!(::INSTANCE.isInitialized)){
                INSTANCE= Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, name =MY_DATABASE)
                    .allowMainThreadQueries()
                    .createFromAsset("database/dictionary.db")
                    .build()
            }
        }
        fun getInstance(): MyDatabase{
            return INSTANCE
        }
    }
    abstract fun getDictionaryDao(): DictionaryDao
}