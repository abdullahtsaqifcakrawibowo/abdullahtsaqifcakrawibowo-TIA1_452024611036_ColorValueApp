package com.example.colorvalueapp

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ColorViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = ColorDatabase.getInstance(application).colorDao()
    var colorList = mutableStateOf<List<Color>>(emptyList())

    init { loadData() }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = dao.getAll()
            withContext(Dispatchers.Main) { colorList.value = data }
        }
    }

    fun addColor(hex: String, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(Color(hex = hex, name = name))
            loadData()
        }
    }

    fun deleteColor(color: Color) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.delete(color)
            loadData()
        }
    }
}