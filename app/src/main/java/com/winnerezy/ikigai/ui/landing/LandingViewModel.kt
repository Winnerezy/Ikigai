import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winnerezy.ikigai.api.DetailsResponse
import com.winnerezy.ikigai.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class LandingViewModel : ViewModel() {
    private val _response = MutableStateFlow<DetailsResponse?>(null)
    val response: StateFlow<DetailsResponse?> = _response

    private val _mangaId = MutableStateFlow("")
    private val mangaId: StateFlow<String> = _mangaId

    fun setId(id: String) {
        _mangaId.value = id
        loadLandingPage()
    }

    private fun loadLandingPage() {
        viewModelScope.launch {
            try {
                val res = RetrofitInstance.api.getDetails(mangaId.value)
                if (res.isSuccessful) {
                    _response.value = res.body()
                    Log.d("Alert", response.value.toString())
                } else {
                    Log.e("Alert", "Response unsuccessful: ${res.code()}")
                }
            } catch (e: IOException) {
                Log.e("Alert", "Error Found")
            } catch (e: Exception) {
                Log.e("Incoming", "Exception is ${e.message}")
            }
        }
    }
}
