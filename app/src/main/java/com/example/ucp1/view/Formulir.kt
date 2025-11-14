package com.example.ucp1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPage(
    onHomeButtonClick: () -> Unit
) {
    var txtMatkul by remember { mutableStateOf("") }
    var txtAngkatan by remember { mutableStateOf("") }

    val matkul: List<String> = listOf("PAM", "PAW", "PWS")
    val angkatan: List<String> = listOf("2022", "2023", "2024")
    var expanded by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(top = 60.dp, bottom = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formulir Tambah Presensi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier
                //.fillMaxSize()
                .padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
                .align(Alignment.CenterHorizontally),
            colors = CardDefaults.cardColors(colorResource(R.color.white))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Nama Matkul",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = txtMatkul,
                            onValueChange = {},
                            readOnly = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            label = { Text("Pilih Status") },
                            trailingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.KeyboardArrowDown,
                                        null,
                                        tint = colorResource(R.color.orange)
                                    )
                                }
                            },
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            modifier = Modifier
                                .background(colorResource(R.color.orange)),
                            onDismissRequest = { expanded = false }
                        ) {
                            matkul.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        txtMatkul = item
                                        expanded = false
                                    },
                                    colors = MenuDefaults.itemColors(textColor = Color.White),
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                )
                            }
                        }
                    }
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Angkatan",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    ExposedDropdownMenuBox(
                        expanded = expanded2,
                        onExpandedChange = { expanded2 = it },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = txtAngkatan,
                            onValueChange = {},
                            readOnly = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            label = { Text("Pilih Angkatan") },
                            trailingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.KeyboardArrowDown,
                                        null,
                                        tint = colorResource(R.color.orange)
                                    )
                                }
                            },
                        )
                        ExposedDropdownMenu(
                            expanded = expanded2,
                            modifier = Modifier
                                .background(colorResource(R.color.orange)),
                            onDismissRequest = { expanded2 = false }
                        ) {
                            angkatan.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        txtAngkatan = item
                                        expanded2 = false
                                    },
                                    colors = MenuDefaults.itemColors(textColor = Color.White),
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}