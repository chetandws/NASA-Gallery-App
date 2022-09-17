package com.cjlabs.nasagalleryapp.view.adapter

import com.cjlabs.nasagalleryapp.model.NasaGallery

interface ItemClickListener {
    fun itemClicked(model:NasaGallery)
}