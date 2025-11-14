package com.example.ucp1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
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
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters
import java.util.Date
import java.util.Locale

private fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPage(
    onHomeButtonClick: () -> Unit
) {
    var txtMatkul by remember { mutableStateOf("") }
    var txtAngkatan by remember { mutableStateOf("") }
    var txtTgl by remember { mutableStateOf("") }
    var txtJam by remember { mutableStateOf("") }
    var txtDosen by remember { mutableStateOf("") }
    var txtMateri by remember { mutableStateOf("") }

    var kuliah by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }
    var tgl by remember { mutableStateOf("") }
    var waktu by remember { mutableStateOf("") }
    var dosen by remember { mutableStateOf("") }
    var materi by remember { mutableStateOf("") }

    val matkul: List<String> = listOf("PAM", "PAW", "PWS")
    val angkatan: List<String> = listOf("2022", "2023", "2024")
    val jam: List<String> = listOf("08:50 - 11.30", "13.20 - 16.20")
    var expanded by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    val isAngkatanEnabled = txtMatkul.isNotEmpty()
    val isTglEnabled = txtAngkatan.isNotEmpty()
    val isJamEnabled = txtTgl.isNotEmpty()
    val isDosenEnabled = txtJam.isNotEmpty()
    val isMateriEnabled = txtDosen.isNotEmpty()

    val zonaWaktu = ZoneId.of("Asia/Jakarta")
    val (awalMinggu, akhirMinggu) = remember {
        val today = LocalDate.now(zonaWaktu)
        val start = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        val end = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))
        Pair(start, end)
    }
    val zonaUTC = ZoneId.of("UTC")
    val selectableDates = remember (awalMinggu, akhirMinggu) {
        object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val tanggalTerpilih = Instant.ofEpochMilli(utcTimeMillis)
                    .atZone(zonaUTC)
                    .toLocalDate()
                return !tanggalTerpilih.isBefore(awalMinggu) && !tanggalTerpilih.isAfter(akhirMinggu)
            }
        }
    }
    val datePickerState = rememberDatePickerState(selectableDates = selectableDates)

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDatePicker = false
                        datePickerState.selectedDateMillis?.let {
                            txtTgl = convertMillisToDate(it)
                        }
                    }
                ) {
                    Text("Pilih")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Batal")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    if(showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            containerColor = colorResource(R.color.white),
            icon = {Icon(Icons.Filled.CheckCircle,
                null,
                modifier = Modifier
                    .size(64.dp),
                tint = colorResource(R.color.orange),)},
            title = {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Berhasil", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = colorResource(R.color.orange))
                    Text(text = "Data berhasil disimpan",  fontWeight = FontWeight.Normal, fontSize = 16.sp, color = colorResource(R.color.orange))
                }
            },
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Mata Kuliah", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Text(text = kuliah, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Angkatan", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Text(text = tahun, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Tanggal", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Text(text = tgl, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Jam", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Text(text = waktu, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Dosen", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Text(text = dosen, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Materi", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.orange))
                    Text(text = materi, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.orange))
                }
            },
            confirmButton = {
                Button(onClick = onHomeButtonClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.orange),
                        contentColor = colorResource(R.color.white)
                    )) {
                    Text("Ok",  fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .padding(top = 60.dp, bottom = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formulir Tambah Presensi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Card(
            modifier = Modifier
                .padding(top = 12.dp, start = 24.dp, end = 24.dp)
                .align(Alignment.CenterHorizontally),
            colors = CardDefaults.cardColors(colorResource(R.color.white))
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp)
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
                            onValueChange = {txtMatkul = it},
                            readOnly = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            label = { Text("Pilih Matkul") },
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
                        onExpandedChange = {
                            if (isAngkatanEnabled) {
                                expanded2 = it
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = txtAngkatan,
                            enabled = isAngkatanEnabled,
                            onValueChange = {},
                            readOnly = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            label = { Text("Pilih Angkatan") },
                            trailingIcon = {
                                IconButton(onClick = {
                                    if (isAngkatanEnabled) {}
                                }, enabled = isAngkatanEnabled
                                    ) {
                                    Icon(Icons.Filled.KeyboardArrowDown,
                                        null,
                                        tint = colorResource(R.color.orange),
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
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Tanggal",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    TextField(
                        value = txtTgl,
                        onValueChange = { txtTgl = it },
                        label = {Text("Pilih Tanggal")},
                        readOnly = true,
                        enabled = isTglEnabled,
                        shape = RoundedCornerShape(12.dp),
                        trailingIcon = {
                            IconButton(onClick = {if (isTglEnabled) showDatePicker = true}) {
                                Icon(
                                    Icons.Filled.DateRange, contentDescription = "Pilih Tanggal"
                                )}
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Jam",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Column {
                        jam.forEach { item ->
                            Row(modifier = Modifier
                                .selectable(
                                    selected = txtJam == item,
                                    onClick = { if (isJamEnabled) txtJam = item }
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = txtJam == item,
                                    onClick = { if (isJamEnabled) txtJam = item }
                                )
                                Text(
                                    text = item,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Dosen",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    TextField(
                        value = txtDosen,
                        enabled = isDosenEnabled,
                        singleLine = true,
                        onValueChange = { txtDosen = it},
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Materi",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    TextField(
                        value = txtMateri,
                        enabled = isMateriEnabled,
                        onValueChange = { txtMateri = it},
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.lightorange),
                    contentColor = Color.White
                ),
                onClick = onHomeButtonClick,
                modifier = Modifier.width(160.dp),
            ) {
                Text(
                    "Kembali",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = colorResource(R.color.orange)
                ),
                enabled = txtMatkul.isNotEmpty() &&
                        txtAngkatan.isNotEmpty() &&
                        txtTgl.isNotEmpty() &&
                        txtJam.isNotEmpty() &&
                        txtDosen.isNotEmpty(),
                onClick = {
                    kuliah = txtMatkul
                    tahun = txtAngkatan
                    tgl = txtTgl
                    waktu = txtJam
                    dosen = txtDosen
                    materi = txtMateri
                    showDialog = true
                },
                modifier = Modifier.width(160.dp),
            ) {
                Text(
                    "Tambah",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}