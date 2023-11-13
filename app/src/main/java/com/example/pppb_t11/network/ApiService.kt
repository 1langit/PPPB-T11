package com.example.pppb_t11.network

import com.example.pppb_t11.model.Articles
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("articles")
    fun getAllArticles() : Call<Articles>
}