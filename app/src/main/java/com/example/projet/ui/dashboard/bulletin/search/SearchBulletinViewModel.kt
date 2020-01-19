package com.example.projet.ui.dashboard.bulletin.search

import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.ui.base.BaseViewModel
import javax.inject.Inject

class SearchBulletinViewModel @Inject constructor() : BaseViewModel() {
    /**
     * variables
     */
    var isEnableLiveEvent: SingleLiveEvent<Boolean> = SingleLiveEvent()

    /**
     * enable button
     * for first step
     */
    fun enableButton(cin: String) {
        this.isEnableLiveEvent.value = (cin.isNotEmpty())
    }


}