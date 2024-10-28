package com.example.pertemuan_4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val dataGender = listOf("Laki-Laki", "Perempuan")

    var confnama by remember { mutableStateOf("") }
    var confemail by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var confgender by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text(text = "Nama") },
            placeholder = { Text(text = "Isi nama anda") },
            modifier = modifier.fillMaxWidth()
        )
        Row {
            dataGender.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = { gender = selectedGender }
                    )
                    Text(text = selectedGender)
                }
            }
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi email anda") },
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text(text = "Alamat") },
            placeholder = { Text(text = "Isi alamat anda") },
            modifier = modifier.fillMaxWidth()
        )
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = { Text(text = "No Telepon") },
            placeholder = { Text(text = "Isi no telepon anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Button(onClick = {
            confnama = nama
            confemail = email
            confalamat = alamat
            confnotelepon = notelepon
            confgender = gender
        }) {
            Text(text = "Simpan")
        }

        // Menampilkan data setelah tombol "Simpan" ditekan
        if (confnama.isNotEmpty() || confemail.isNotEmpty() || confalamat.isNotEmpty() || confnotelepon.isNotEmpty() || confgender.isNotEmpty()) {
            Spacer(modifier = Modifier.size(8.dp)) // Jarak antara form dan hasil
            TampilData(Param = "Nama", Argu = confnama)
            TampilData(Param = "Email", Argu = confemail)
            TampilData(Param = "Alamat", Argu = confalamat)
            TampilData(Param = "No Telepon", Argu = confnotelepon)
            TampilData(Param = "Gender", Argu = confgender)
        }
    }
}

@Composable
fun TampilData(Param: String, Argu: String) {
    Column(modifier = Modifier.padding(vertical = 2.dp)) { // Mengurangi padding agar lebih rapat
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$Param:",
                modifier = Modifier.weight(0.5f),
                color = Color.Black
            )
            Text(
                text = Argu,
                modifier = Modifier.weight(1.5f),
                color = Color.Black
            )
        }
    }
}
