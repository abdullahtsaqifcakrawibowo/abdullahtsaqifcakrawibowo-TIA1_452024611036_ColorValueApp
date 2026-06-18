package com.example.colorvalueapp

import androidx.room.Entity
import androidx.room.PrimaryKey

// Menandakan ini adalah tabel bernama 'colors'
@Entity(tableName = "colors")
data class Color(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // ID otomatis bertambah
    val hex: String, // Kode warna (ex: #FF0000)
    val name: String // Nama warna (ex: Merah)
)