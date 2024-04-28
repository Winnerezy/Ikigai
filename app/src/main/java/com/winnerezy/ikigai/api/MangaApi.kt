package com.winnerezy.ikigai.api

import com.winnerezy.ikigai.model.Manga
import retrofit2.Response
import retrofit2.http.GET

interface MangaApi {

    @GET("/manga?limit=15")
    suspend fun getManga(): Response<List<Manga>>
}