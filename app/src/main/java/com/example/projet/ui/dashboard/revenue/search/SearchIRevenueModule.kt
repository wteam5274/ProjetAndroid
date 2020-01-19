package com.example.projet.ui.dashboard.revenue.search

import androidx.lifecycle.ViewModelProvider
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SearchIRevenueModule {

    @Provides
    internal fun providesViewModel(): SearchRevenueViewModel {
        return SearchRevenueViewModel()
    }

    @Provides
    internal fun provideViewModelProvider(searchRevenueViewModel: SearchRevenueViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(searchRevenueViewModel)
    }

}