package com.winnerezy.ikigai.api

import com.google.gson.annotations.SerializedName
import com.winnerezy.ikigai.model.Manga
import java.io.Serializable

data class DetailsResponse (
    @SerializedName("data")
    var data : Manga
) : Serializable