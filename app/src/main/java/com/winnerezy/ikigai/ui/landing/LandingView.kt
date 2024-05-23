import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.winnerezy.ikigai.api.mangaImage
import com.winnerezy.ikigai.ui.explore.MangaCard

@Composable
fun LandingView(param: String, navController: NavController) {
    val viewModel = remember { LandingViewModel() }

    LaunchedEffect(param) {
        viewModel.setId(param)
    }

    val mangaDetails by viewModel.response.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "<- Go back", modifier = Modifier.clickable { navController.popBackStack() })
                Spacer(modifier = Modifier.height(10.dp))
                val title = mangaDetails?.data?.attributes?.title?.en
                val id = mangaDetails?.data?.id
                val info = mangaDetails
                    ?.data
                    ?.relationships
                    ?.map { relationship -> relationship }
                    ?.filter { relationship -> relationship.type == "cover_art" }
                val fileName = info?.find { it.type == "cover_art" }
                    ?.attributes?.fileName
                    if(fileName != null && id != null){
                      val link =  mangaImage(id, fileName)
                        AsyncImage(model = link, contentDescription = null)
                    }

//

            }

        }
    }
}
