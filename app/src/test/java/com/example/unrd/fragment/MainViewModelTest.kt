package com.example.unrd.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.unrd.core.repository.useCase.GetUiModelUseCase
import com.jraska.livedata.test
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Flowable
import org.junit.Rule
import org.junit.Test
import java.io.IOException

class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val getUiModelUseCase: GetUiModelUseCase = mockk()

    private val sut = MainViewModel(getUiModelUseCase)

    @Test
    fun `get uiModel`() {
        val uiModel: MainFragmentUiModel = mockk()
        every { getUiModelUseCase.get() } returns Flowable.just(uiModel)

        sut.uiModel.test().assertValue(uiModel)
        sut.errorEvent.test().assertNoValue()
    }

    @Test
    fun `get uiModel when failure`() {
        val failure: IOException = mockk()
        every { getUiModelUseCase.get() } returns Flowable.error(failure)

        sut.uiModel.test().assertNoValue()
        sut.errorEvent.test().assertValue(failure)
    }
}