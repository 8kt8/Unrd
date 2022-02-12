package com.example.unrd.fragment

import com.example.unrd.core.service.model.ResultResponse
import javax.inject.Inject

class MainFragmentUiModelMapper @Inject constructor() {

    fun map(response: ResultResponse) = with(response.data){
        MainFragmentUiModel(
            title = name,
            duration = "Duration: $duration",
            shortDescription = shortSummary,
            longDescription = fullSummary,
            backgroundImage = backgroundImages.first().uri,
            introUrl = introVideos.first().uri,
            previewUrl = previewsMedia.first().uri,
            imageUrl = images.first().uri
        )
    }
}