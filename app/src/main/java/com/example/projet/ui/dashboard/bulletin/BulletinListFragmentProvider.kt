package com.example.projet.ui.dashboard.bulletin

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BulletinListFragmentProvider {
    @ContributesAndroidInjector(modules = [BulletinModule::class])
    internal abstract fun provideRevenueListFragmentFactory(): BulletinListFragment
}