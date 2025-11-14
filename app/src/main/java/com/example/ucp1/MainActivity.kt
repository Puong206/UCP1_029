package com.example.ucp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ucp1.ui.theme.UCP1Theme
import com.example.ucp1.view.FormPage
import com.example.ucp1.view.LoginPage
import com.example.ucp1.view.ProfilPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UCP1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    //LoginPage {}
//                    ProfilPage(
//                        onLogoutButtonClick = {},
//                        onFormButtonClick = {},
//                    )
//                    FormPage(
//                        onHomeButtonClick = {}
//                    )
                    App()
                }
            }
        }
    }
}