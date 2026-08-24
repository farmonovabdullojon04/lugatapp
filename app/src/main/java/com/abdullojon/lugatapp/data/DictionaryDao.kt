package com.abdullojon.lugatapp.data

import androidx.room.Dao
import androidx.room.Query
import org.w3c.dom.Text

@Dao
interface DictionaryDao {
    @Query("SELECT*FROM dictionary")
    fun getAll(): List<Dictionary>

    @Query("SELECT*FROM dictionary WHERE english LIKE '%' || :text || '%'")
    fun getAllBySearch(text: String): List<Dictionary>
}