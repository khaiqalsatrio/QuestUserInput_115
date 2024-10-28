package com.example.pertemuan_4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.select

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-Lai, Perempuan")

    var confnama by remember { mutableStateOf("") }
    var confemail by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var confgender by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "nama")
            },
            placeholder = {
                Text(text = "isi nama anda")
            },
            modifier = modifier.fillMaxWidth()
        )
        dataGender.forEach{selectedGender->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = gender == selectedGender,
                    onClick = {gender = selectedGender}
                )
            Text(text = selectedGender)}
            }
        TextField(
            value = email,
            onValueChange = {nama = it},
            label = {
                Text(text = "email")
            },
            placeholder = {
                Text(text = "isi email anda")
            },
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda")
            },
            modifier = modifier.fillMaxWidth()
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "notelepon")
            },
            placeholder = {
                Text(text = "isi notelepon anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
        )
        Button(onClick = {
            confnama = nama
            confemail = email
            confalamat = alamat
            confnotelepon = notelepon
            confgender = gender
        } ) {
            Text(text = "Simpan")
        }
        TampilData(
            Param = nama,
            Argu =  confnama)
        TampilData(
            Param = email,
            Argu =  confemail)
        TampilData(
            Param = alamat,
            Argu =  confalamat)
        TampilData(
            Param = notelepon,
            Argu =  confnotelepon)
    }
}


@Composable
fun TampilData(Param: String, Argu: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = Param,
                modifier = Modifier.weight(0.8f),
                color = Color.Black // Set details text color to white
            )
            Text(
                text = Argu,
                modifier = Modifier.weight(2f),
                color = Color.Black // Set details text color to white
            )
        }
    }
}

