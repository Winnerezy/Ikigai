package com.winnerezy.ikigai.ui.explore

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.winnerezy.ikigai.api.mangaImage
import com.winnerezy.ikigai.model.Util
import com.winnerezy.ikigai.navigation.Navigation
import com.winnerezy.ikigai.ui.BottomBarNavigation

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreView(navController: NavController) {
    val viewModel = ExploreViewModel()
    val manga by viewModel.response.collectAsState()
    var query by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)) {
        LazyColumn(modifier =
        Modifier
            .fillMaxSize()) {
            item{
                Text(
                    text = "Explore",
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
                        onValueChange = { newValue -> query = newValue },
                        placeholder = { Text("Search here...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 20.dp),
                        shape = CircleShape,
                    )
                }
            }
            item {
               LazyColumn(modifier = Modifier
                   .height(500.dp)
                   .padding(10.dp)
                   .fillMaxWidth(),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   item {
                       manga?.data?.forEach {mangaItem->
                           val title = mangaItem.attributes.title.en
                           val id = mangaItem.id
                           val info = mangaItem
                               .relationships
                               .map { relationship -> relationship }
                               .filter { relationship -> relationship.type == "cover_art" }
                           val fileName = info.find { it.type == "cover_art" }
                               ?.attributes?.fileName
                           if (fileName != null) {
                               val link = mangaImage(id, fileName)
                               MangaCard(id = id, title = title, link = link, navController = navController)
                           }
                       }
                   }
               }

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

@Composable
fun MangaCard(id: String, title: String?, link: String, navController: NavController){
    Column(modifier = Modifier.clickable ( onClick = { navController.navigate(Navigation.LandingPage.route.plus("/$id"))  })) {
        Box(modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .border(width = 2.dp, color = Color.White)
        ) {
            AsyncImage(
                model = link,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
            )
        }
        if (title != null) {
            Text(text = title, modifier = Modifier.width(100.dp), maxLines = 1, textAlign = TextAlign.Center)
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

}
