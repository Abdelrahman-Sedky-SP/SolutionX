package com.example.solutionx.android.extentions

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

fun <M> String.getModelFromJSON(tokenType: Type): M = Gson().fromJson(this, tokenType)

inline fun <reified T> parseJsonFile(context: Context, fileName: String): List<T> {
    return try {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<T>>() {}.type
        val itemList: List<T> = jsonString.getModelFromJSON(type)

        itemList
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}