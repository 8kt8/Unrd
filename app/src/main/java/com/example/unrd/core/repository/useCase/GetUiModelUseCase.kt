package com.example.unrd.core.repository.useCase

import com.example.unrd.core.repository.ResultRepository
import com.example.unrd.fragment.MainFragmentUiModel
import com.example.unrd.fragment.MainFragmentUiModelMapper
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class GetUiModelUseCase @Inject constructor(
    private val resultRepository: ResultRepository,
    private val mapper: MainFragmentUiModelMapper
) {

    fun get(): Flowable<MainFragmentUiModel> =
        resultRepository.getData().map(mapper::map)

}