package com.example.solutionx.data.models

data class Currency(
    override val id: Int,
    override val name: String,
    val code: String,
    val symbol: String,
    val country: String,
    override var isSelected: Boolean = false
) : SingleItem
