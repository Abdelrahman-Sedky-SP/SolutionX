package com.example.solutionx.data.models

import com.google.gson.annotations.SerializedName

data class Country(
    override val id: Int,
    override val name: String,
    val nationality: String,
    val currency: String,
    val code: String,
    @SerializedName("phone_code")
    val phoneCode: String,
    val flag: String,
    override var isSelected: Boolean = false
) : SingleItem
