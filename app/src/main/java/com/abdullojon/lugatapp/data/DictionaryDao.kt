package com.abdullojon.lugatapp.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DictionaryDao {
    @Query("SELECT * FROM dictionary")
    fun getAll(): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE english LIKE '%' || :text || '%'")
    fun getAllBySearch(text: String): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE is_favourite = 1")
    fun getFavourites(): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE is_favourite = 1 AND english LIKE '%' || :text || '%'")
    fun getFavouritesBySearch(text: String): List<Dictionary>

    @Query("SELECT * FROM dictionary WHERE id = :id")
    fun getById(id: Int): Dictionary?

    @Query("UPDATE dictionary SET is_favourite = :isFav WHERE id = :id")
    fun updateFavourite(id: Int, isFav: Int)
}