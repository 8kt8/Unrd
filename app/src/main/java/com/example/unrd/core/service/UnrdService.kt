package com.example.unrd.core.service

import com.example.unrd.core.service.model.ResultResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface UnrdService {

    @GET("/unrd-scratch/resp.json")
    fun getResult(): Single<ResultResponse>
}
