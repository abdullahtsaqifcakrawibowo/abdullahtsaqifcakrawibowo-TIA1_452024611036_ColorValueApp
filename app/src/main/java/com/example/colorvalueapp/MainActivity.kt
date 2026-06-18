package com.example.colorvalueapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ColorScreen()
                }
            }
        }
    }
}

@Composable
fun ColorScreen(vm: ColorViewModel = viewModel()) {
    var hex by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    val list by vm.colorList

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = hex, onValueChange = { hex = it },
            label = { Text("Kode Hex (#FF0000)") }, modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = name, onValueChange = { name = it },
            label = { Text("Nama Warna") }, modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if(hex.isNotBlank() && name.isNotBlank()) {
                    vm.addColor(hex, name)
                    hex = ""; name = ""
                }
            }, modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan ke Database")
        }
        Spacer(Modifier.height(20.dp))
        LazyColumn {
            items(list) { color ->
                Card(Modifier.padding(vertical = 4.dp).fillMaxWidth()) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.size(40.dp).background(
                            try { ComposeColor(android.graphics.Color.parseColor(color.hex)) }
                            catch(e: Exception) { ComposeColor.Gray }
                        ))
                        Spacer(Modifier.width(16.dp))
                        Column(Modifier.weight(1f)) {
                            Text(color.name, style = MaterialTheme.typography.titleMedium)
                            Text(color.hex)
                        }
                        IconButton(onClick = { vm.deleteColor(color) }) {
                            Icon(Icons.Default.Delete, contentDescription = null, tint = ComposeColor.Red)
                        }
                    }
                }
            }
        }
    }
}