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

@Composable
fun LandingView(param: String, navController: NavController) {
    val viewModel = remember { LandingViewModel() }

    LaunchedEffect(param) {
        viewModel.setId(param)
    }

    val mangaDetails by viewModel.response.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "<- Go back", modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = mangaDetails.toString())
        }
    }
}
