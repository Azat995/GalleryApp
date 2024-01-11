package com.southernsunrise.galleryapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class GalleryImageItemModel(
    val imageId: Long,
    val imageSourceUrl: String
) : Parcelable
