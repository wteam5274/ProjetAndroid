package com.example.projet.ui.splash

import androidx.lifecycle.ViewModelProvider
import com.example.projet.data.repository.ScreensRepositoryImpl
import com.example.projet.ui.onboarding.OnBoardingViewModel
import com.example.projet.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule {


    @Provides
    internal fun providesViewModel(): SplashViewModel {
        return SplashViewModel()
    }

    @Provides
    internal fun provideViewModelProvider(splashViewModel: SplashViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(splashViewModel)
    }
}