package com.winnerezy.ikigai.ui.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class ExploreViewModel: ViewModel() {
    private var _query = MutableStateFlow("")
    var query: StateFlow<String> = _query

    fun search(query: String){
        viewModelScope.launch {
            println("Search is $query")
        }
    }
}