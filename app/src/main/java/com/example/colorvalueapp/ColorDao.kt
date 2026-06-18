package com.example.colorvalueapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ColorDao {
    @Query("SELECT * FROM colors")
    suspend fun getAll(): List<Color>

    @Insert
    suspend fun insert(color: Color)

    @Delete
    suspend fun delete(color: Color)
}