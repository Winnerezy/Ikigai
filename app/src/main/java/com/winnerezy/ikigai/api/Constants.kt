package com.winnerezy.ikigai.api

import android.util.Log

fun mangaImage(id: String, fileName: String): String {
        val link = "https://uploads.mangadex.org/covers/${id}/${fileName}.256.jpg"
    return link
}
