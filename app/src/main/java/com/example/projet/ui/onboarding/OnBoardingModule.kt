package com.example.projet.ui.onboarding

import androidx.lifecycle.ViewModelProvider
import com.example.projet.data.repository.ScreensRepositoryImpl
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class OnBoardingModule {

    @Provides
    internal fun providesViewModel(screensRepositoryImpl: ScreensRepositoryImpl): OnBoardingViewModel {
        return OnBoardingViewModel(screensRepositoryImpl)
    }

    @Provides
    internal fun provideViewModelProvider(onBoardingViewModel: OnBoardingViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(onBoardingViewModel)
    }
}