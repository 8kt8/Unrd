package com.example.unrd.core.service

import javax.inject.Inject

class BackendConfig @Inject constructor() {
    val apiUrl = "https://s3-eu-west-1.amazonaws.com"
    val readTimeout = 60L
    val connectionTimeout = 60L
}