package com.example.projet.ui.dashboard

import com.example.projet.ui.dashboard.birth.ResultIdentityFragment
import com.example.projet.ui.dashboard.birth.ResultIdentityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ResultIdentityFragmentProvider {
    @ContributesAndroidInjector(modules = [ResultIdentityModule::class])
    internal abstract fun provideResultIdentityFragmentFactory(): ResultIdentityFragment
}