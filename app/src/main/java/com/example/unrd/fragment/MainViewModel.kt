package com.example.unrd.fragment

import androidx.lifecycle.LiveDataReactiveStreams.fromPublisher
import com.example.unrd.core.common.BaseViewModel
import com.example.unrd.core.repository.useCase.GetUiModelUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUiModelUseCase: GetUiModelUseCase
): BaseViewModel(){

    val uiModel
        get() = fromPublisher(getUiModelUseCase.get()
            .doOnError { triggerError(it) }
            .onErrorComplete()
        )
}