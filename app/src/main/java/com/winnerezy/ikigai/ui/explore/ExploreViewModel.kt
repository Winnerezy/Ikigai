package com.winnerezy.ikigai.ui.explore

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winnerezy.ikigai.api.RetrofitInstance
import com.winnerezy.ikigai.model.Manga
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

open class ExploreViewModel: ViewModel() {
    private var _query = MutableStateFlow("")
    var query: StateFlow<String> = _query

    fun search(query: String){
        viewModelScope.launch {
            println("Search is $query")
        }
    }

    private val _manga = MutableStateFlow<List<Manga>>(emptyList())
    val manga: Flow<List<Manga>> = _manga

    init {
        loadManga()
    }

    private fun loadManga() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getManga()
                if (response.isSuccessful) {
                    _manga.value = response.body() ?: emptyList()
                } else {
                    println("Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("API call failed: ${e.message}")
            }
        }
    }
}
