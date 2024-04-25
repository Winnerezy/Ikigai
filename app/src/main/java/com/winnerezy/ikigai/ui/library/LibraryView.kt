package com.winnerezy.ikigai.ui.library

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import com.winnerezy.ikigai.ui.theme.IkigaiTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LibraryView() {
    val viewModel = LibraryViewModel()

    IkigaiTheme {
        Surface(modifier = Modifier
            .fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .border(width = 6.dp, color = Color.Red)
                    .scrollable(rememberScrollState(), Orientation.Horizontal)) {
               item {
                   Box(modifier = Modifier
                       .fillMaxWidth()
                       .border(width = 6.dp, color = Color.Red)){
                       Text ( text = "Library",
                           fontSize = 30.sp,
                           modifier = Modifier
                               .padding(14.dp),

                           )
                   }
               }
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun LibraryPreview() {
        LibraryView()
}