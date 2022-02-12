package com.example.unrd.core.repository

import com.example.unrd.core.schedulers.CoreSchedulers
import com.example.unrd.core.schedulers.TestSchedulers
import com.example.unrd.core.service.UnrdService
import com.example.unrd.core.service.model.ResultResponse
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Test

class ResultRepositoryTest {

    private val service: UnrdService = mockk()
    private val coreSchedulers: CoreSchedulers = TestSchedulers()

    private val sut = ResultRepository(
        unrdService = service,
        coreSchedulers = coreSchedulers
    )

    @Test
    fun refresh() {
        val response: ResultResponse = mockk()
        every { service.getResult() } returns Single.just(response)

        sut.refresh().test()
            .assertComplete()

        sut.getData().test().assertValue(response)
    }

    @Test
    fun `refreshAll when error`() {
        val error = RuntimeException()
        every { service.getResult() } returns Single.error(error)

        sut.refresh().test()
            .assertFailure(RuntimeException::class.java)

        sut.getData().test().assertNoValues()
    }
}