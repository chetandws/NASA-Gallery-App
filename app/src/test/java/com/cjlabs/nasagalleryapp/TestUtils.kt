package com.cjlabs.nasagalleryapp

import com.cjlabs.nasagalleryapp.model.NasaGallery
import com.cjlabs.nasagalleryapp.viewmodel.NasaViewModelTest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.InputStream
import java.lang.reflect.Type

object TestUtils {
    private val gson = Gson()
    private fun getJson(path: String): String {
        val uri = javaClass.classLoader!!.getResource(path)
        val file = File(uri.path.replace("%20", " "))
        return String(file.readBytes())
    }

    fun getNasaList(path: String): List<NasaGallery> {
        val listType: Type = object : TypeToken<List<NasaGallery>>() {}.type
        val list: List<NasaGallery> =
            gson.fromJson(getJson(path), listType)
        return list.sortedByDescending { it.date }
    }
    
}