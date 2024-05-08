package com.winnerezy.ikigai.api

import com.google.gson.annotations.SerializedName
import com.winnerezy.ikigai.model.Manga
import java.io.Serializable

data class DataResponse<T>(
    @SerializedName("data")
    var data : List<T>
) : Serializable