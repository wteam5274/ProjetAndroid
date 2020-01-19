package com.example.projet.ui.dashboard.revenue.details

import androidx.lifecycle.ViewModelProvider
import com.example.projet.data.repository.RevenuesRepositoryImpl
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class DetailRevenueModule {

    @Provides
    internal fun providesViewModel(revenuesRepositoryImpl: RevenuesRepositoryImpl): DetailRevenueViewModel {
        return DetailRevenueViewModel(revenuesRepositoryImpl)
    }

    @Provides
    internal fun provideViewModelProvider(detailRevenueViewModel: DetailRevenueViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(detailRevenueViewModel)
    }
}