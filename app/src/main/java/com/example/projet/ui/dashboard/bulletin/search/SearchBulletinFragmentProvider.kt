package com.example.projet.ui.dashboard.bulletin.search

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchBulletinFragmentProvider {
    @ContributesAndroidInjector(modules = [SearchIBulletinModule::class])
    internal abstract fun provideSearchBulletinFragmentFactory(): SearchBulletinFragment
}