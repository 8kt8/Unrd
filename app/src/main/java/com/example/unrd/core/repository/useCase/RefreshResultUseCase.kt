package com.example.unrd.core.repository.useCase

import com.example.unrd.core.repository.ResultRepository
import javax.inject.Inject

class RefreshResultUseCase @Inject constructor(
    private val resultRepository: ResultRepository
) {

    fun refresh() = resultRepository.refresh()
}