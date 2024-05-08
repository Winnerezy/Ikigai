package com.winnerezy.ikigai.api

import androidx.lifecycle.LiveData
import com.winnerezy.ikigai.model.Manga
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApi {

    @GET("/manga?limit=10&includedTagsMode=AND&excludedTagsMode=OR&contentRating[]=safe&contentRating[]=suggestive&contentRating[]=erotica&order[latestUploadedChapter]=desc&includes[]=manga&includes[]=cover_art&includes[]=author")
    suspend fun getManga(): Response<DataResponse<Manga>>

    @GET("/manga/{id}?includes[]=manga&includes[]=cover_art&includes[]=author&includes[]=artist&includes[]=tag&includes[]=creator")
    suspend fun getDetails(@Path("id") id: String): Response<DetailsResponse>
}