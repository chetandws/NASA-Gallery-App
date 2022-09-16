package com.cjlabs.nasagalleryapp.utils

import android.app.Application
import android.content.Context

class NasaApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: NasaApp? = null

        fun getAppContext(): Context = instance!!.applicationContext
    }

}