package com.winnerezy.ikigai.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Manga (
    val id : String,
    val type: String,
    val attributes: Attributes,
    val relationships: List<Relationships>
)