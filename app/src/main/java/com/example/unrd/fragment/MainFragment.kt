package com.example.unrd.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.unrd.R
import com.example.unrd.common.LoadingDrawable
import com.example.unrd.common.viewBinding
import com.example.unrd.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: MainViewModel by viewModels()

    private val binding: MainFragmentBinding by viewBinding(MainFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoundView()
    }

    private fun onBoundView() = with(binding) {
        viewModel.uiModel.observe(viewLifecycleOwner) {
            loadBackground(it.backgroundImage)
            title.text = it.title
            duration.text = it.duration
            shortDescription.text = it.shortDescription
            shortDescription.visibility = View.VISIBLE
            longDescription.text = it.longDescription
            longDescription.visibility = View.VISIBLE
            setIntroClickListener(it.introUrl)
            setImageClickListener(it.imageUrl)
            setPreviewClickListener(it.previewUrl)
        }
        viewModel.errorEvent.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadBackground(imageUrl: String){
        Glide.with(requireContext())
            .load(imageUrl)
            .placeholder(LoadingDrawable())
            .centerInside()
            .into(binding.imageBackground)
    }

    private fun setIntroClickListener(imageUrl: String){
       val direction = MainFragmentDirections.actionToVideoFragment(imageUrl)
       binding.introVideo.setOnClickListener {
           findNavController().navigate(direction)
       }
    }

    private fun setPreviewClickListener(imageUrl: String){
        val direction = MainFragmentDirections.actionToVideoFragment(imageUrl)
        binding.video.setOnClickListener {
            findNavController().navigate(direction)
        }
    }

    private fun setImageClickListener(imageUrl: String){
        val direction = MainFragmentDirections.actionToImageFragment(imageUrl)
        binding.image.setOnClickListener {
            findNavController().navigate(direction)
        }
    }

}