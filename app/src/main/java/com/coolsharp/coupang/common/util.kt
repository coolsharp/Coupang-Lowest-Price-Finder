package com.coolsharp.coupang.common

import android.content.Context
import com.coolsharp.coupang.data.model.SoundsData
import com.google.gson.Gson
import java.io.InputStream

fun parseSoundsDataWithGson(context: Context, rawResourceId: Int): SoundsData? {
    return try {
        val inputStream: InputStream = context.resources.openRawResource(rawResourceId)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        Gson().fromJson(jsonString, SoundsData::class.java)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}