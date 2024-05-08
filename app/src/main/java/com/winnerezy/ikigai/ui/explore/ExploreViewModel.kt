package com.winnerezy.ikigai.ui.explore

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winnerezy.ikigai.api.DataResponse
import com.winnerezy.ikigai.api.RetrofitInstance
import com.winnerezy.ikigai.model.Manga
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class ExploreViewModel: ViewModel() {
    private var _query = MutableStateFlow("")
    var query: StateFlow<String> = _query
    val response = MutableStateFlow<DataResponse<Manga>?>(null)
    //val response = _response
    fun search(query: String) {
        viewModelScope.launch {
            println("Search is $query")
        }
    }
    init {
        getManga()
    }

    private fun getManga() {
        viewModelScope.launch {
             try {
               val res = RetrofitInstance.api.getManga()
                if (res.isSuccessful && res.body() != null) {
                    response.value = res.body()

                } else {
                    Log.e("Alert", "Response unsuccessful: ${res.code()}")
                }
            } catch (e: IOException){
                Log.e("Alert", "Error ${e.message}")
                return@launch
            } catch (e: Exception) {
                Log.e("Alert", "Exception: ${e.message}")
                return@launch
            }

        }
    }

}


