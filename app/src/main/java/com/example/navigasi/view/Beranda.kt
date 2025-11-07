package com.example.navigasi.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigasi.R
import com.example.navigasi.ui.theme.NavigasiTheme

@Composable
fun BerandaScreen(onSubmitButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selamat Datang", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(32.dp))
        // TODO: Ganti dengan logo aplikasi Anda
        Image(
            painter = painterResource(id = R.drawable.Logo_KMTI),
            contentDescription = "Logo"
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text("Pascal Pahlevi Pasha", fontSize = 20.sp)
        Text("20250140001", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onSubmitButtonClicked) {
            Text(stringResource(R.string.submit))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BerandaPreview() {
    NavigasiTheme {
        BerandaScreen({})
    }
}
