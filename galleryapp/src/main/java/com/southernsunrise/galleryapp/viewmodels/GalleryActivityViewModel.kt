package com.southernsunrise.galleryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.southernsunrise.galleryapp.R
import com.southernsunrise.galleryapp.models.GalleryImageItemModel

class GalleryActivityViewModel : ViewModel() {
    private var _galleryPhotosList: MutableLiveData<ArrayList<GalleryImageItemModel>> =
        MutableLiveData()
    val galleryPhotosList: LiveData<ArrayList<GalleryImageItemModel>> get() = _galleryPhotosList

    init {
        setupImagedList()
    }

    private fun setupImagedList() {

        val imagesUrlList = arrayListOf<String>(
            "https://i.pinimg.com/564x/de/2d/ec/de2dec038626359a95653c5531ddf430.jpg",
            "https://i.pinimg.com/736x/25/7f/aa/257faa399b0f2586a1ef0037106b5ae2.jpg",
            "https://i.pinimg.com/564x/82/1d/b6/821db6e1ab4e7653964e4d070e1678e5.jpg",
            "https://i.pinimg.com/564x/87/03/d5/8703d54ff87e74bba6d455daa061bf55.jpg",
            "https://i.pinimg.com/564x/64/ad/12/64ad127f65a6478dd5cc44b1c31483eb.jpg",
            "https://i.pinimg.com/564x/13/69/97/1369977eeaa7680acd298b7f74d07dc4.jpg",
            "https://i.pinimg.com/564x/39/5c/5a/395c5a8f96db2d4df659c3cf7c441424.jpg",
            "https://i.pinimg.com/564x/9d/12/7f/9d127f63412b6c9864f13954d2f07d70.jpg",
            "https://i.pinimg.com/564x/87/75/e1/8775e15605f949b5d0253ccdfad23e66.jpg",
            "https://i.pinimg.com/564x/a1/63/b2/a163b2996d0b672635869f8f631ec26d.jpg",
            "https://i.pinimg.com/564x/d9/03/b5/d903b51e8be2a9f02bd2e09a84a829b5.jpg",
            "https://i.pinimg.com/564x/c6/6e/40/c66e4000dfe23fe9e0c0a9c7cd20a98d.jpg",
            "https://i.pinimg.com/564x/dc/4f/21/dc4f21932a6a6453c91585f514f8d73f.jpg",
            "https://i.pinimg.com/564x/8b/9e/c5/8b9ec5862333c042f2d4ad540bdcd05f.jpg",
            "https://i.pinimg.com/564x/8f/39/5b/8f395b44c1580b95c1f9fa4b59501c3b.jpg"
        )

        val imagesList = ArrayList<GalleryImageItemModel>()
        repeat(5) {
            for (url in imagesUrlList) {
                imagesList.add(
                    GalleryImageItemModel(
                        System.nanoTime() * (1..999).random(),
                        url
                    )
                )
                _galleryPhotosList.value = imagesList
            }
        }

    }
}
