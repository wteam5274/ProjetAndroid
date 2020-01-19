package com.example.projet.ui.dashboard.revenue

import androidx.lifecycle.ViewModelProvider
import com.example.projet.data.repository.RevenuesRepositoryImpl
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class RevenueModule {

    @Provides
    internal fun providesViewModel(revenuesRepositoryImpl: RevenuesRepositoryImpl): RevenueViewModel {
        return RevenueViewModel(revenuesRepositoryImpl)
    }

    @Provides
    internal fun provideViewModelProvider(revenueViewModel: RevenueViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(revenueViewModel)
    }
}