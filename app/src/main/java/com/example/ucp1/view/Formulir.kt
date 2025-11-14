package com.example.ucp1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPage(
    onHomeButtonClick: () -> Unit
){
    val matkul: List<String> = listOf("PAM", "PAW", "PWS")
    val angkatan: List<String> = listOf("2022", "2023", "2024")
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Formulir Tambah Presensi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier
                //.fillMaxSize()
                .padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Nama Matkul",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    modifier = Modifier.fillMaxWidth()
                ) {
//                    TextField(
//                        value =
//                    )
                }
            }
        }
    }
}