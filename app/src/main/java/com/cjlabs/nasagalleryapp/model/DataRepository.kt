package com.cjlabs.nasagalleryapp.model

import com.cjlabs.nasagalleryapp.NasaApp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.lang.reflect.Type

class DataRepository {

    var gson = Gson()
    private fun readFromAsset() = NasaApp.getAppContext().assets.open(JSON_FILE_NAME)
        .bufferedReader().use(BufferedReader::readText)

    fun getGalleryData(): List<NasaGallery> {
        val listType: Type = object : TypeToken<List<NasaGallery>>() {}.type
        val list: List<NasaGallery> = gson.fromJson(readFromAsset(), listType)
        return list.sortedByDescending(NasaGallery::date)
    }

    companion object {
        const val JSON_FILE_NAME = "data.json"
    }
}