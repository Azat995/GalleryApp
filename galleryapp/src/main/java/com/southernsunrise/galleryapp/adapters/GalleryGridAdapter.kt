package com.southernsunrise.galleryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.southernsunrise.galleryapp.databinding.GalleryGridRecycerViewItemviewBinding
import com.southernsunrise.galleryapp.models.GalleryImageItemModel
import com.southernsunrise.galleryapp.recyclerview.diffutils.GalleryGridRecyclerViewDiffUtil
import com.southernsunrise.galleryapp.recyclerview.viewholders.GalleryImageViewHolder

class GalleryGridAdapter(private val onItemClickCallBack: (Int) -> Unit) :
    ListAdapter<GalleryImageItemModel, GalleryImageViewHolder>(GalleryGridRecyclerViewDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImageViewHolder {
        return GalleryImageViewHolder(
            GalleryGridRecycerViewItemviewBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: GalleryImageViewHolder, position: Int) {
        holder.bind(onItemClickCallBack, currentList[position], position)
    }

}