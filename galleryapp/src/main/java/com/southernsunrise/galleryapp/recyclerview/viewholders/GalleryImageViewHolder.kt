package com.southernsunrise.galleryapp.recyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.southernsunrise.galleryapp.databinding.GalleryGridRecycerViewItemviewBinding
import com.southernsunrise.galleryapp.models.GalleryImageItemModel

class GalleryImageViewHolder(private val itemViewBinding: GalleryGridRecycerViewItemviewBinding) :
    RecyclerView.ViewHolder(itemViewBinding.root) {
    fun bind(
        onItemClickCallBack: (Int) -> Unit,
        galleryImageItemModel: GalleryImageItemModel,
        position: Int
    ) = with(itemViewBinding) {
        root.setOnClickListener { onItemClickCallBack(position) }
        galleryImageItemImageView.load(galleryImageItemModel.imageSourceUrl)
    }
}