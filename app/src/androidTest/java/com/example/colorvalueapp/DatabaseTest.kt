package com.example.colorvalueapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var db: ColorDatabase
    private lateinit var dao: ColorDao

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ColorDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = db.colorDao()
    }

    @After
    fun closeDb() { db.close() }

    @Test
    fun insertAndReadTest() = runBlocking {
        val color = Color(hex = "#FF0000", name = "Red")
        dao.insert(color)
        val all = dao.getAll()
        assertEquals("Red", all[0].name)
    }
}