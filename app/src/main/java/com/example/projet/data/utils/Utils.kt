package com.example.projet.data.utils

import android.content.Context
import com.example.projet.data.models.Screens
import com.google.gson.Gson
import java.io.InputStream


object Utils {
    fun readJSONFromAsset(context: Context, fileName: String): String? {
        var json: String?
        try {
            val inputStream: InputStream = context.assets.open(fileName)
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}