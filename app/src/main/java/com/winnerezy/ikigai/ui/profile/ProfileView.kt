package com.winnerezy.ikigai.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileView() {
    val viewModel = ProfileViewModel()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
        LazyColumn(modifier =
        Modifier
            .fillMaxSize()) {
            item{
                Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 30.dp, top = 100.dp)
                )
            }
        }

    }


}