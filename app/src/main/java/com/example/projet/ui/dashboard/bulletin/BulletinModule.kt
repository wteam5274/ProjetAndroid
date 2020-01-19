package com.example.projet.ui.dashboard.bulletin

import androidx.lifecycle.ViewModelProvider
import com.example.projet.data.repository.BulletinRepositoryImpl
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class BulletinModule {

    @Provides
    internal fun providesViewModel(bulletinRepositoryImpl: BulletinRepositoryImpl): BulletinViewModel {
        return BulletinViewModel(bulletinRepositoryImpl)
    }

    @Provides
    internal fun provideViewModelProvider(bulletinViewModel: BulletinViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(bulletinViewModel)
    }
}