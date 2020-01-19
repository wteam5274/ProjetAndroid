package com.example.projet.ui.dashboard.birth

import androidx.lifecycle.ViewModelProvider
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SearchIdentityModule {

    @Provides
    internal fun providesViewModel(): SearchIdentityViewModel {
        return SearchIdentityViewModel()
    }

    @Provides
    internal fun provideViewModelProvider(birthViewModel: SearchIdentityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(birthViewModel)
    }

}