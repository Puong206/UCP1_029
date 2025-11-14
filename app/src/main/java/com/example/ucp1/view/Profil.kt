package com.example.ucp1.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

data class DataKartu(
    val matkul: String,
    val angkatan: String,
    val kelas: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilPage (
    onLogoutButtonClick: () -> Unit,
    onFormButtonClick: () -> Unit
){
    val items = listOf(
        DataKartu(
            matkul = "Pengembangan Aplikasi Mobile",
            angkatan = "2023",
            kelas = "A"
        ),
        DataKartu(
            matkul = "Pengembangan Aplikasi Web",
            angkatan = "2022",
            kelas = "B"
        ),
        DataKartu(
            matkul = "Pengembangan Web Service",
            angkatan = "2022",
            kelas = "A"
        ),
        DataKartu(
            matkul = "Pengembangan Web Framework",
            angkatan = "2022",
            kelas = "B"
        ),
        DataKartu(
            matkul = "Prototyping",
            angkatan = "2022",
            kelas = "B"
        ),
    )

    Box(modifier = Modifier.fillMaxSize())
    {
        Scaffold(
            containerColor = colorResource(R.color.orange),
            topBar = {
                TopAppBar(colors = TopAppBarDefaults.topAppBarColors(colorResource(R.color.orange)),
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(painter = painterResource(R.drawable.profil_kereta),
                                null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
                                Text(
                                    "Arya Bagas Saputra",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    "20230140029",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                            }
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(containerColor = colorResource(R.color.orange)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = colorResource(R.color.orange)
                            ),
                            onClick = onLogoutButtonClick,
                            modifier = Modifier.width(160.dp),
                        ) {
                            Text(
                                "Logout",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = colorResource(R.color.orange)
                            ),
                            onClick = onFormButtonClick,
                            modifier = Modifier.width(160.dp),
                        ) {
                            Text(
                                "Formulir",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        )
        {
            frame ->
            Box(modifier = Modifier
                .padding(frame)
                .fillMaxSize())
            {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Profil",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
                LazyColumn(modifier = Modifier
                    .padding(start = 12.dp, top = 32.dp, end = 12.dp)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    items(items) { item ->
                        ElevatedCard(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                                contentColor = colorResource(R.color.orange)
                            ))
                        {
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Column {
                                    Text(
                                        "Nama Matkul",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        item.matkul,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                }
                                Column {
                                    Text(
                                        "Angkatan",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        item.angkatan,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                }
                            }
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    "Kelas",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    item.kelas,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}