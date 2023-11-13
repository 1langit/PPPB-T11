package com.example.pppb_t11.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("title") val title: String,
    @SerializedName("summary") val summary: String,
    @SerializedName("url") val url: String
)
