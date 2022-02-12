package com.example.unrd

import com.example.unrd.core.common.BaseViewModel
import com.example.unrd.core.repository.useCase.RefreshResultUseCase
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val refreshResultUseCase: RefreshResultUseCase
): BaseViewModel(){

    fun refresh() {
        refreshResultUseCase.refresh().subscribe({
            Logger.d("Refresh data success")
        }, {
            Logger.d("Refresh data error ${it.localizedMessage}")
        })
    }
}