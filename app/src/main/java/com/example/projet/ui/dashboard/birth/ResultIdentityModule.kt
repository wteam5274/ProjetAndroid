package com.example.projet.ui.dashboard.birth

import androidx.lifecycle.ViewModelProvider
import com.example.projet.data.repository.PersonRepositoryImpl
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class ResultIdentityModule {

    @Provides
    internal fun providesViewModel(personRepositoryImpl: PersonRepositoryImpl): ResultIdentityViewModel {
        return ResultIdentityViewModel(personRepositoryImpl)
    }

    @Provides
    internal fun provideViewModelProvider(resultIdentityViewModel: ResultIdentityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(resultIdentityViewModel)
    }
}