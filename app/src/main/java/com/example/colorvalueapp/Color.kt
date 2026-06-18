package com.example.colorvalueapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class Color(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val hex: String,
    val name: String
)