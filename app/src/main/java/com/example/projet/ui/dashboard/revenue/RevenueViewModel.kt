package com.example.projet.ui.dashboard.revenue

import androidx.lifecycle.MutableLiveData
import com.example.projet.data.models.Revenue
import com.example.projet.data.repository.RevenuesRepositoryImpl
import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.extensions.withDefaultSchedulers
import com.example.projet.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class RevenueViewModel @Inject constructor(private val revenuesRepositoryImpl: RevenuesRepositoryImpl) :
    BaseViewModel() {

    var revenuesMutableList: MutableLiveData<List<Revenue>> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()
    var showProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun getRevenues(cin: String) {
        revenuesRepositoryImpl.getRevenuesByCIN(cin).withDefaultSchedulers()
            .subscribe({
                Timber.d("revenuesRepositoryImpl onSuccess $it")
                revenuesMutableList.value = it
                showProgress.value = false
            }, {
                Timber.d("revenuesRepositoryImpl onFailed $it")
                errorState.value = it
                showProgress.value = false
            })
    }
}