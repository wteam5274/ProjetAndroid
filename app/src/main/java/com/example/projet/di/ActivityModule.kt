package com.example.projet.di

import com.example.projet.ui.dashboard.MainActivity
import com.example.projet.ui.dashboard.ResultIdentityFragmentProvider
import com.example.projet.ui.dashboard.birth.BirthActivity
import com.example.projet.ui.dashboard.birth.SearchIdentityFragmentProvider
import com.example.projet.ui.dashboard.bulletin.BulletinActivity
import com.example.projet.ui.dashboard.bulletin.BulletinListFragmentProvider
import com.example.projet.ui.dashboard.bulletin.search.SearchBulletinFragmentProvider
import com.example.projet.ui.dashboard.revenue.RevenueActivity
import com.example.projet.ui.dashboard.revenue.RevenueListFragmentProvider
import com.example.projet.ui.dashboard.revenue.details.DetailRevenueProvider
import com.example.projet.ui.dashboard.revenue.search.SearchRevenueFragmentProvider
import com.example.projet.ui.onboarding.OnBoardingActivity
import com.example.projet.ui.onboarding.OnBoardingModule
import com.example.projet.ui.splash.SplashActivity
import com.example.projet.ui.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [SplashModule::class])
    internal abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [SearchIdentityFragmentProvider::class,
            ResultIdentityFragmentProvider::class]
    )
    internal abstract fun contributeBirthActivity(): BirthActivity

    @ContributesAndroidInjector(
        modules = [SearchBulletinFragmentProvider::class
            , BulletinListFragmentProvider::class]
    )
    internal abstract fun contributeBulletinActivity(): BulletinActivity

    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [OnBoardingModule::class])
    internal abstract fun contributeOnBoardingActivity(): OnBoardingActivity

    @ContributesAndroidInjector(
        modules = [RevenueListFragmentProvider::class,
            DetailRevenueProvider::class,
            SearchRevenueFragmentProvider::class]
    )
    internal abstract fun contributeRevenueActivity(): RevenueActivity
}