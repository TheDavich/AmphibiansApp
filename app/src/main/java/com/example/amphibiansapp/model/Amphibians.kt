package com.example.amphibiansapp.model

import kotlinx.serialization.SerialName

data class Amphibians(
    val name: String,
    val type: String,
    val description: String,
    @SerialName("img_src")
    val imgSrc: String,
)
