package com.example.navigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasi.R
import com.example.navigasi.ui.theme.NavigasiTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilanData(
    onBackToBerandaClick: () -> Unit,
    onBackToFormClick: () -> Unit
) {
    val darkColor = Color.Black
    val lightColor = Color(0xFFF5F5F5) // Light gray

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "List Daftar Peserta", color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = darkColor)
            )
        },
        containerColor = lightColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DetailItem(label = stringResource(id = R.string.nama_lengkap), value = "Hafizh Harimurti")
                DetailItem(label = stringResource(id = R.string.jenis_kelamin), value = "Laki-laki")
                DetailItem(label = "STATUS PERKAWINAN", value = "Menikah")
                DetailItem(label = stringResource(id = R.string.alamat), value = "Tamantirta 2")
            }

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onBackToBerandaClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = darkColor),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Beranda", color = Color.White)
                }
                Button(
                    onClick = onBackToFormClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = darkColor),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "Formulir Pendaftaran", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = label.uppercase(),
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Default,
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TampilDataPreview() {
    NavigasiTheme {
        TampilanData(onBackToBerandaClick = {}, onBackToFormClick = {})
    }
}
