package com.southernsunrise.galleryapp.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import coil.load
import com.southernsunrise.galleryapp.R
import com.southernsunrise.galleryapp.databinding.FragmentImageViewerImageContainerBinding
import com.southernsunrise.galleryapp.models.GalleryImageItemModel
import com.southernsunrise.galleryapp.viewmodels.GalleryActivityViewModel

class ImageViewerSingleImageContainerFragment : Fragment() {

    private var _binding: FragmentImageViewerImageContainerBinding? = null
    private val binding get() = _binding!!
    private var currentImagePosition: Int? = null
    private val galleryViewModel by activityViewModels<GalleryActivityViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // get the current image position to show
        currentImagePosition = arguments?.getInt(requireActivity().getString(R.string.image))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageViewerImageContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupImageView()
    }

    private fun setupImageView() {
        binding.imageContainerImageView.load(currentImagePosition?.let {
            galleryViewModel.galleryPhotosList.value?.get(
                it
            )?.imageSourceUrl
        })
    }

}