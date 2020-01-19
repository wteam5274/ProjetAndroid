package com.example.projet.ui.dashboard.revenue.search

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchRevenueFragmentProvider {
    @ContributesAndroidInjector(modules = [SearchIRevenueModule::class])
    internal abstract fun provideSearchRevenueFragmentFactory(): SearchRevenueFragment
}