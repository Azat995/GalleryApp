package com.southernsunrise.galleryapp.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.activity.viewModels
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.southernsunrise.galleryapp.fragments.ImageViewerFragment
import com.southernsunrise.galleryapp.R
import com.southernsunrise.galleryapp.databinding.ActivityGalleryMainBinding
import com.southernsunrise.galleryapp.models.GalleryImageItemModel
import com.southernsunrise.galleryapp.recyclerview.decorators.GalleryRecyclerViewItemDecorator
import com.southernsunrise.galleryapp.adapters.GalleryGridAdapter
import com.southernsunrise.galleryapp.utils.openFragment
import com.southernsunrise.galleryapp.viewmodels.GalleryActivityViewModel

class MainGalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryMainBinding
    private lateinit var galleryGridAdapter: GalleryGridAdapter
    private val galleryViewModel by viewModels<GalleryActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setupImagesList()
        setupGalleryGrid()
        setupObservers()
    }

    private fun setupObservers() {
        setGalleryImagesListObserver()
    }

    private fun setGalleryImagesListObserver() {
        galleryViewModel.galleryPhotosList.observe(this) {
            updateGalleryGrid(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateGalleryGrid(imagesList: ArrayList<GalleryImageItemModel>) {
        galleryGridAdapter.apply {
            submitList(imagesList)
            notifyDataSetChanged()
        }

    }

    private fun setupGalleryGrid() {
        galleryGridAdapter =
            GalleryGridAdapter(::onGalleryGridImageItemClickCallBack).also {
                it.submitList(
                    galleryViewModel.galleryPhotosList.value
                )
            }

        binding.photosStaggeredGridRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(3, VERTICAL)
            adapter = galleryGridAdapter
            setItemDecoration(GalleryRecyclerViewItemDecorator(4))
        }

    }

    private fun onGalleryGridImageItemClickCallBack(imageItemPosition: Int) {
        // open ImageViewerFragment when grid item is clicked and pass the selected
        // image item position for it to be shown first in the view pager

        if (galleryViewModel.galleryPhotosList.value!!.isNotEmpty()) {
            val imageViewerFragment = ImageViewerFragment().apply {
                    arguments = Bundle()
                    arguments!!.putInt(this@MainGalleryActivity.getString(R.string.current_item_position), imageItemPosition)
                }

            openFragment(R.id.container_main, imageViewerFragment, true)

        }
    }

    private fun RecyclerView.setItemDecoration(decor: GalleryRecyclerViewItemDecorator) {
        this.apply {
            addItemDecoration(decor)
            setPadding(decor.strokeWidth)
        }
    }


}
