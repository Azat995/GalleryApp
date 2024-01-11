package com.southernsunrise.galleryapp.recyclerview.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.southernsunrise.galleryapp.models.GalleryImageItemModel

class GalleryGridRecyclerViewDiffUtil : DiffUtil.ItemCallback<GalleryImageItemModel>() {
    override fun areItemsTheSame(oldItem: GalleryImageItemModel, newItem: GalleryImageItemModel): Boolean {
        return oldItem.imageId == newItem.imageId
    }

    override fun areContentsTheSame(oldItem: GalleryImageItemModel, newItem: GalleryImageItemModel): Boolean {
        return oldItem == newItem
    }

}