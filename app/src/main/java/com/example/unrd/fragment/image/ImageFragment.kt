package com.example.unrd.fragment.image

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.unrd.R
import com.example.unrd.common.LoadingDrawable
import com.example.unrd.common.viewBinding
import com.example.unrd.databinding.ImageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageFragment : Fragment(R.layout.image_fragment) {

    private val binding: ImageFragmentBinding by viewBinding(ImageFragmentBinding::bind)

    private val args: ImageFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoundView()
    }

    private fun onBoundView() = with(binding) {
        Glide.with(requireContext())
            .load(args.url)
            .placeholder(LoadingDrawable())
            .centerInside()
            .into(image)
    }
}
