package com.example.projet.ui.dashboard.birth

import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.ui.base.BaseViewModel
import javax.inject.Inject

class SearchIdentityViewModel @Inject constructor() : BaseViewModel() {
    /**
     * variables
     */
    var isEnableLiveEvent: SingleLiveEvent<Boolean> = SingleLiveEvent()

    /**
     * enable button
     * for first step
     */
    fun enableButtonForFirstStep(
        firstName: String, lastName: String, cin: String,
        birthDate: String
    ) {
        this.isEnableLiveEvent.value = (firstName.isNotEmpty() && lastName.isNotEmpty() && cin.isNotEmpty()
                && birthDate.isNotEmpty())
    }


}