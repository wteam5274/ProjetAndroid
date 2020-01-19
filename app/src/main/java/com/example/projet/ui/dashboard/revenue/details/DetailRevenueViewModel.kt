package com.example.projet.ui.dashboard.revenue.details

import androidx.lifecycle.MutableLiveData
import com.example.projet.data.models.Revenue
import com.example.projet.data.repository.RevenuesRepositoryImpl
import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.extensions.withDefaultSchedulers
import com.example.projet.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class DetailRevenueViewModel @Inject constructor(private val revenuesRepositoryImpl: RevenuesRepositoryImpl) :
    BaseViewModel() {

    var revenueMutable: MutableLiveData<Revenue> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun getRevenues(id: Int) {
        revenuesRepositoryImpl.getRevenueById(id).withDefaultSchedulers()
            .subscribe({
                Timber.d("revenuesRepositoryImpl onSuccess $it")
                revenueMutable.value = it
            }, {
                Timber.d("revenuesRepositoryImpl onFailed $it")
                errorState.value = it
            })
    }
}