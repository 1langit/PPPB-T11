package com.example.pppb_t11.model

import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("results")
    val data: List<Data>
)
