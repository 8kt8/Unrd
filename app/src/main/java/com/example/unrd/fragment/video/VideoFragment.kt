package com.example.unrd.fragment.video

import android.os.Bundle
import android.view.View
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.unrd.R
import com.example.unrd.common.viewBinding
import com.example.unrd.databinding.VideoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment(R.layout.video_fragment) {

    private val binding: VideoFragmentBinding by viewBinding(VideoFragmentBinding::bind)

    private val args: VideoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBoundView()
    }

    private fun onBoundView() = with(binding) {
        video.setMediaController(MediaController(requireContext()))
        video.setVideoPath(args.url)
        video.start()
    }
}