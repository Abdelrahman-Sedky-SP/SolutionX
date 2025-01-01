package com.example.solutionx.data.models

data class Filter(
    override val id: Int,
    override val name: String,
    override var isSelected: Boolean = false
) : SingleItem
