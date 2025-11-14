package com.example.ucp1.view

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
fun LoginPage(
    onStartButtonClick: () -> Unit
){
    var txtUser by remember { mutableStateOf("") }
    var txtPw by remember { mutableStateOf("") }

    var user by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            containerColor = Color.White,
            icon = { Icon(Icons.Filled.Info,
                null,
                modifier = Modifier.size(64.dp),
                tint = colorResource(R.color.orange))
            },
            title = {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Setuju?",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(text = "Anda yakin ingin menyetujui syarat dan ketentuan yang berlaku?",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.orange),
                        contentColor = Color.White
                    )
                ) {
                    Text("Setuju", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        showDialog = false
                        checked = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = colorResource(R.color.orange)
                    )
                ) {
                    Text("Batal", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize())
    {
        Scaffold(
            containerColor = colorResource(R.color.orange),
            contentColor = Color.White,
            topBar ={
                TopAppBar(colors = TopAppBarDefaults.topAppBarColors(colorResource(R.color.orange)),
                    title = {
                        Text("Login",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            },
        ) {
            frame ->
            Column (modifier = Modifier
                .padding(frame)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Column (
                    modifier = Modifier
                        .padding (start = 24.dp, top = 24.dp, end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Username",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    TextField(
                        value = txtUser,
                        singleLine = true,
                        onValueChange = {txtUser = it},
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding (start = 24.dp, top = 4.dp, end = 24.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Password",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    TextField(
                        value = txtPw,
                        singleLine = true,
                        onValueChange = {txtPw = it},
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .padding (start = 12.dp, top = 4.dp, end = 12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                            showDialog = true
                        }
                    )
                    Text("Saya menyetujui syarat & ketentuan yang berlaku",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal)
                }
                Spacer(modifier = Modifier.height(360.dp))
                Button(
                    enabled = checked,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = colorResource(R.color.orange)
                    ),
                    onClick = onStartButtonClick,
                    modifier = Modifier.width(240.dp)
                ) {
                    Text(
                        "Login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}