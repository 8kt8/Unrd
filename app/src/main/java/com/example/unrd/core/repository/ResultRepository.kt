package com.example.unrd.core.repository

import androidx.annotation.WorkerThread
import com.example.unrd.core.schedulers.CoreSchedulers
import com.example.unrd.core.service.UnrdService
import com.example.unrd.core.service.model.ResultResponse
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultRepository @Inject constructor(
    private val unrdService: UnrdService,
    private val coreSchedulers: CoreSchedulers
){

    private val data: Subject<ResultResponse> =
        BehaviorSubject.create<ResultResponse>().toSerialized()

    @WorkerThread
    fun refresh(): Completable = unrdService.getResult()
        .doAfterSuccess(::updateResults)
        .subscribeOn(coreSchedulers.networkIO)
        .ignoreElement()

    fun getData(): Flowable<ResultResponse> = data.toFlowable(BackpressureStrategy.LATEST)

    private fun updateResults(updatedData: ResultResponse){
        data.onNext(updatedData)
    }
}