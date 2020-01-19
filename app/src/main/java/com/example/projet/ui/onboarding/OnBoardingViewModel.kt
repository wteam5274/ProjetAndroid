package com.example.projet.ui.onboarding

import androidx.lifecycle.MutableLiveData
import com.example.projet.data.repository.ScreensRepositoryImpl
import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.extensions.withDefaultSchedulers
import com.example.projet.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class OnBoardingViewModel @Inject constructor(private val screensRepositoryImpl: ScreensRepositoryImpl) :
    BaseViewModel() {

    val mutableLiveData = MutableLiveData<Screens>()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun getScreens() {
        addDisposable(
            screensRepositoryImpl.getScreens()
                .withDefaultSchedulers()
                .subscribe({
                    Timber.d("getScreens onSuccess $it")
                    mutableLiveData.value = Screens(screens = it.map {
                        ScreenItem(
                            title = it.title,
                            description = it.description,
                            screenImg = it.screenImg
                        )
                    })
                }, {
                    Timber.d("getScreens onFailed ${it.message}")
                    errorState.value = it
                })
        )
    }


}