package com.example.projet.ui.dashboard.bulletin

import androidx.lifecycle.MutableLiveData
import com.example.projet.data.models.Bulletin
import com.example.projet.data.repository.BulletinRepositoryImpl
import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.extensions.withDefaultSchedulers
import com.example.projet.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class BulletinViewModel @Inject constructor(private val bulletinRepositoryImpl: BulletinRepositoryImpl) :
    BaseViewModel() {

    var bulletinMutable: MutableLiveData<Bulletin> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun getBulletin(cin: String) {
        addDisposable(bulletinRepositoryImpl.getBulletins(cin).withDefaultSchedulers()
            .subscribe({
                Timber.d("bulletinRepositoryImpl getBulletin onSuccess $it")
                bulletinMutable.value = it
            }, {
                Timber.d("bulletinRepositoryImpl getBulletin onFailed $it")
                errorState.value = it
            }))
    }
}