package com.southernsunrise.galleryapp.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.southernsunrise.galleryapp.fragments.ImageViewerSingleImageContainerFragment
import com.southernsunrise.galleryapp.R
import com.southernsunrise.galleryapp.models.GalleryImageItemModel

class ImageViewerViewPagerAdapter(
    private val imagesList: ArrayList<GalleryImageItemModel>,
    private val fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = imagesList.size

    override fun createFragment(position: Int): Fragment {
        // create image viewPager item fragment and pass the current image position
        val imageViewerSingleImageContainerFragment =
            ImageViewerSingleImageContainerFragment().apply {
            arguments = Bundle().apply { putInt(fragmentActivity.getString(R.string.image), position) }
        }
        return imageViewerSingleImageContainerFragment
    }

}
