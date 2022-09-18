package com.cjlabs.nasagalleryapp.viewmodel

import com.cjlabs.nasagalleryapp.TestUtils
import com.cjlabs.nasagalleryapp.model.DataRepository
import com.cjlabs.nasagalleryapp.model.NasaGallery
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.Assert.*
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test
import java.util.*

class NasaViewModelTest {

    private val nasaViewModel: NasaViewModel = NasaViewModel()

    @MockK
    private lateinit var dataRepository: DataRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        nasaViewModel.dataRepository = dataRepository
        every { dataRepository.getGalleryData() } returns TestUtils.getNasaList(JSON_FILE_NAME)
    }


    @Test
    fun `Test setItemPosition`() {
        nasaViewModel.setItemPosition(nasaGallery)

        assertNotNull(nasaViewModel.nasaGalleryList)
        assertSame(
            Arrays.asList(ArrayList::class.java)::class.java,
            nasaViewModel.nasaGalleryList::class.java
        )
        assertEquals(LIST_COUNT, nasaViewModel.nasaGalleryList.size)
    }

    @Test
    fun `Test getItemPosition`() {
        nasaViewModel.setItemPosition(nasaGallery)

        val itemPosition = nasaViewModel.getItemPosition()

        assertEquals(ITEM_POSITION, itemPosition)
    }

    @After
    fun afterTest() {
        unmockkAll()
    }

    companion object {
        const val JSON_FILE_NAME = "asset/data.json"
        const val LIST_COUNT = 26
        const val ITEM_POSITION = 24
        val nasaGallery: NasaGallery = NasaGallery(
            "Steve Mazlin",
            "2019-12-03",
            "some explanation",
            "some hdurl",
            "media type",
            "service version",
            "M27: The Dumbbell Nebula",
            "https://apod.nasa.gov/apod/image/1912/M27_Mazlin_960.jpg"
        )
        @AfterClass
        @JvmStatic
        fun afterClass() {
            unmockkAll()
        }
    }
}