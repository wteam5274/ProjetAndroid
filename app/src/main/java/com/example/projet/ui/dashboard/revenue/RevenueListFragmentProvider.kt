package com.example.projet.ui.dashboard.revenue

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RevenueListFragmentProvider {
    @ContributesAndroidInjector(modules = [RevenueModule::class])
    internal abstract fun provideRevenueListFragmentFactory(): RevenueListFragment
}