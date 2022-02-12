package com.example.unrd.core.repository.useCase

import com.example.unrd.core.repository.ResultRepository
import com.example.unrd.core.service.model.ResultResponse
import com.example.unrd.fragment.MainFragmentUiModel
import com.example.unrd.fragment.MainFragmentUiModelMapper
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Flowable
import org.junit.Test

class GetUiModelUseCaseTest {

    private val resultRepository: ResultRepository = mockk()
    private val mapper: MainFragmentUiModelMapper = mockk()

    private val sut = GetUiModelUseCase(resultRepository, mapper)

    @Test
    fun get() {
        val resultResponse: ResultResponse = mockk()
        val expectedResult: MainFragmentUiModel = mockk()

        every { resultRepository.getData() } returns Flowable.just(resultResponse)
        every { mapper.map(resultResponse) } returns expectedResult

        sut.get().test().assertValue(expectedResult)
    }
}