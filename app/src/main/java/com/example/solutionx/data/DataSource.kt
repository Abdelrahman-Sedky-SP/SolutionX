package com.example.solutionx.data

import android.content.Context
import com.example.solutionx.android.extentions.parseJsonFile
import com.example.solutionx.data.models.Country
import com.example.solutionx.data.models.Currency
import com.example.solutionx.data.models.Filter

object DataSource {

    fun getCountries(context: Context): List<Country> = parseJsonFile(context, "countries.json")

    fun getCurrencies(context: Context): List<Currency> = parseJsonFile(context, "currencies.json")

    fun getFilter(context: Context): List<Filter> = parseJsonFile(context, "filter.json")

    fun getOrders(): List<String> = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
}