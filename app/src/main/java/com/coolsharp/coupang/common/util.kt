package com.coolsharp.coupang.common

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.coolsharp.coupang.data.model.SoundsData
import com.google.gson.Gson
import java.io.InputStream
import androidx.core.net.toUri

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

fun openUrlInBrowser(context: Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(intent)
    } catch (e: Exception) {
        // 브라우저 앱이 없을 경우 예외 처리
        e.printStackTrace()
    }
}