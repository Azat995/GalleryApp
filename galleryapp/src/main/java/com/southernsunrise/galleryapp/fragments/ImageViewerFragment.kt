package com.southernsunrise.galleryapp.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.southernsunrise.galleryapp.R
import com.southernsunrise.galleryapp.adapters.ImageViewerViewPagerAdapter
import com.southernsunrise.galleryapp.databinding.FragmentImageViewerBinding
import com.southernsunrise.galleryapp.models.GalleryImageItemModel
import com.southernsunrise.galleryapp.viewmodels.GalleryActivityViewModel

class ImageViewerFragment : Fragment() {

    private var _binding: FragmentImageViewerBinding? = null
    private val binding get() = _binding!!
    private var imageViewerViewPagerAdapter: ImageViewerViewPagerAdapter? = null
    private var currentImagePosition: Int? = 0
    private val galleryViewModel by activityViewModels<GalleryActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // image position to be displayed first
        currentImagePosition =
            arguments?.getInt(requireActivity().getString(R.string.current_item_position), 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentImageViewerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImagesViewPager()
    }

    private fun setupImagesViewPager() {
        imageViewerViewPagerAdapter = ImageViewerViewPagerAdapter(
            galleryViewModel.galleryPhotosList.value!!,
            requireActivity()
        )

        binding.imagesViewPager.apply {
            adapter = imageViewerViewPagerAdapter
            // set viewPager current item position according to the selected image
            currentImagePosition?.let { setCurrentItem(it, false) }
            offscreenPageLimit = 6
            isUserInputEnabled = true
        }
    }

}