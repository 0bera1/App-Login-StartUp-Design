package com.example.logindesign

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logindesign.ui.theme.LoginDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Suppress("DEPRECATION")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
    Surface (color = MaterialTheme.colorScheme.primary) {
        val tfKullaniciAdi = remember {
            mutableStateOf("")
        }
        val tfSifre = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "" )
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = {tfKullaniciAdi.value = it},
                label = { Text(text = "Kullanıcı adını giriniz...")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )
            TextField(value = tfSifre.value,
                onValueChange ={tfSifre.value = it},
                label = { Text(text = "Şiifreyi giriniz...")},
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        focusedIndicatorColor = Color.Red
                    )
                )
            Button(onClick = {Log.e("Buton","Giriş Yapıldı.")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier.size(250.dp,50.dp)){
                Text(text = "Giriş Yap")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginDesignTheme {
        Sayfa()
    }
}