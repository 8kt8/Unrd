package com.example.unrd.core.service.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultResponse(
    @Json(name = "result")
    val data: ResultDataResponse
)

@JsonClass(generateAdapter = true)
data class ResultDataResponse(
    @Json(name = "story_id")
    val storyId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "short_summary")
    val shortSummary: String,
    @Json(name = "full_summary")
    val fullSummary: String,
    @Json(name = "duration")
    val duration: String,
    @Json(name = "list_image")
    val images: List<Image>,
    @Json(name = "preview_media")
    val previewsMedia: List<PreviewMedia>,
    @Json(name = "intro_video")
    val introVideos: List<IntroVideo>,
    @Json(name = "background_image")
    val backgroundImages: List<BackgroundImage>
)

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "resource_uri")
    val uri: String
)

@JsonClass(generateAdapter = true)
data class PreviewMedia(
    @Json(name = "resource_uri")
    val uri: String
)

@JsonClass(generateAdapter = true)
data class IntroVideo(
    @Json(name = "resource_uri")
    val uri: String
)

@JsonClass(generateAdapter = true)
data class BackgroundImage(
    @Json(name = "resource_uri")
    val uri: String
)