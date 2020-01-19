package com.example.projet.ui.dashboard.revenue.details

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailRevenueProvider {
    @ContributesAndroidInjector(modules = [DetailRevenueModule::class])
    internal abstract fun provideDetailRevenueFactory(): DetailRevenueFragment
}