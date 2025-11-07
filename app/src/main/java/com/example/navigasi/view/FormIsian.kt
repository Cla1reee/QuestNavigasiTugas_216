package com.example.navigasi.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirPendaftaran(
    onSubmitButtonClicked: () -> Unit,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    val listJenisKelamin: List<String> = listOf("Laki-laki", "Perempuan")
    val listStatus: List<String> = listOf("Janda", "Lajang", "Duda")
    val darkColor = Color.Black
    val lightColor = Color(0xFFF5F5F5) // Light gray

    Column(modifier = modifier.fillMaxSize().background(lightColor)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(darkColor)
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Scrollable content
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(text = "NAMA LENGKAP", fontSize = 12.sp, color = Color.Gray)
            OutlinedTextField(
                value = textNama,
                onValueChange = { textNama = it },
                placeholder = { Text("Isian nama lengkap") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = darkColor,
                    unfocusedBorderColor = Color.LightGray
                )
            )

            Spacer(modifier = Modifier.height(20.dp))


            Text(text = "JENIS KELAMIN", fontSize = 12.sp, color = Color.Gray)
            Column {
                listJenisKelamin.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = textJK == item, onClick = { textJK = item })
                        Text(text = item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


            Text(text = "STATUS PERKAWINAN", fontSize = 12.sp, color = Color.Gray)
            Column {
                listStatus.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textStatus == item,
                            onClick = { textStatus = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = textStatus == item, onClick = { textStatus = item })
                        Text(text = item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // --- ALAMAT ---
            Text(text = "ALAMAT", fontSize = 12.sp, color = Color.Gray)
            OutlinedTextField(
                value = textAlamat,
                onValueChange = { textAlamat = it },
                placeholder = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = darkColor,
                    unfocusedBorderColor = Color.LightGray
                )
            )
        }

        // Buttons at the bottom
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = onBackButtonClicked,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text(text = "Back", color = Color.White, fontSize = 16.sp)
            }
            Button(
                onClick = onSubmitButtonClicked,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = darkColor)
            ) {
                Text(text = "Submit", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FormulirPendaftaranPreview() {
    FormulirPendaftaran(onSubmitButtonClicked = {}, onBackButtonClicked = {})
}
