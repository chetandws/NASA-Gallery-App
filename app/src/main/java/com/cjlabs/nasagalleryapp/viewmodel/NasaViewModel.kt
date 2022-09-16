package com.cjlabs.nasagalleryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cjlabs.nasagalleryapp.model.DataRepository
import com.cjlabs.nasagalleryapp.model.NasaGallery

class NasaViewModel : ViewModel() {

    private val dataRepository = DataRepository()
    private lateinit var nasaGalleryList: List<NasaGallery>

    fun loadData() {
        nasaGalleryList = dataRepository.getGalleryData()
    }

}