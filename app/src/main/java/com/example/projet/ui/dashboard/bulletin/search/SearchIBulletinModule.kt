package com.example.projet.ui.dashboard.bulletin.search

import androidx.lifecycle.ViewModelProvider
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SearchIBulletinModule {

    @Provides
    internal fun providesViewModel(): SearchBulletinViewModel {
        return SearchBulletinViewModel()
    }

    @Provides
    internal fun provideViewModelProvider(searchRevenueViewModel: SearchBulletinViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(searchRevenueViewModel)
    }

}