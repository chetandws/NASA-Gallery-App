package com.cjlabs.nasagalleryapp.viewmodel

import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.cjlabs.nasagalleryapp.model.DataRepository
import com.cjlabs.nasagalleryapp.model.NasaGallery


class NasaViewModel : ViewModel() {
    private val selectedItemPosition = ObservableInt()

    private lateinit var selectedItem: NasaGallery
    lateinit var dataRepository: DataRepository
    val nasaGalleryList: List<NasaGallery> by lazy { loadData() }

    private fun loadData() = dataRepository.getGalleryData()

    fun setItemPosition(model: NasaGallery) {
        selectedItem = model
        selectedItemPosition.set(nasaGalleryList.indexOfFirst {
            it.copyright == model.copyright
                    && it.url == model.url
                    && it.title == model.title
        })
    }

    fun getItemPosition(): Int = selectedItemPosition.get()
}