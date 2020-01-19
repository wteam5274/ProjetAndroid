package com.example.projet.ui.dashboard.birth

import androidx.lifecycle.MutableLiveData
import com.example.projet.data.models.Person
import com.example.projet.data.repository.PersonRepositoryImpl
import com.example.projet.extensions.SingleLiveEvent
import com.example.projet.extensions.withDefaultSchedulers
import com.example.projet.ui.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ResultIdentityViewModel @Inject constructor(private val personRepositoryImpl: PersonRepositoryImpl) :
    BaseViewModel() {

    /**
     * variables
     */
    var personsMutableList: MutableLiveData<Person> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()

    fun getIdentity(cin: String, firstName: String, lastName: String, birthDate: String) {
        personRepositoryImpl.getPersonsByInfo(cin, firstName, lastName, birthDate)
            .withDefaultSchedulers()
            .subscribe({
                Timber.d("personRepositoryImpl onSuccess $it")
                personsMutableList.value = it
            }, {
                Timber.d("personRepositoryImpl onFailed $it")
                errorState.value = it
            })
    }


}