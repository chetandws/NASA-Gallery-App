package com.cjlabs.nasagalleryapp.model

import android.util.Log
import com.cjlabs.nasagalleryapp.utils.NasaApp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class DataRepository {

    private val gson = Gson()
    private fun readFromAsset(): String {
        var jsonData = ""
        val bufferReader = NasaApp.getAppContext().assets.open(JSON_FILE_NAME).bufferedReader()
        jsonData = bufferReader.use { it.readText() }
        Log.d("readFromAsset", jsonData)
        return jsonData
    }

    fun getGalleryData(): List<NasaGallery> {
        val listType: Type = object : TypeToken<List<NasaGallery>>() {}.type
        return gson.fromJson(readFromAsset(), listType)
    }

    companion object {
        const val JSON_FILE_NAME = "data.json"
    }
}