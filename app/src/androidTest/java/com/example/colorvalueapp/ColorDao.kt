package com.example.colorvalueapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ColorDao {
    @Query("SELECT * FROM colors")
    suspend fun getAll(): List<Color> // Mengambil semua data

    @Insert
    suspend fun insert(color: Color) // Menyimpan data

    @Delete
    suspend fun delete(color: Color) // Menghapus data
}