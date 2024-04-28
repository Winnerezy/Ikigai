package com.winnerezy.ikigai.ui.explore

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.key
import androidx.compose.ui.unit.TextUnit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreView() {
    val viewModel = ExploreViewModel()
    var query by remember { mutableStateOf("") }
    val mangaList by viewModel.manga.collectAsState(emptyList())
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
        LazyColumn(modifier =
        Modifier
            .fillMaxSize()) {
            item{
                Text(
                    text = "Search",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 30.dp, top = 100.dp)
                )
            }

            item {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)) {
                    TextField(
                        value = query ,
                        onValueChange = { newValue -> query = newValue  },
                        placeholder = { Text("Search here...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 20.dp),
                        shape = CircleShape,
                    )

                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp, end = 30.dp),
            contentAlignment = Alignment.BottomEnd) {
            Filter()
        }

    }


}

@Composable
fun Filter() {
    Canvas(
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)) {
        drawCircle(
            color = Color.White,
            center = center,
            radius = size.width / 4
        )
    }
}

@Preview
@Composable
fun ExplorePreview() {
    ExploreView()
}