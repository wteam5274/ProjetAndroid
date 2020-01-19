package com.example.projet.ui.dashboard.birth

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ResultIdentityFragmentProvider {
    @ContributesAndroidInjector(modules = [ResultIdentityModule::class])
    internal abstract fun provideBirthResultIdentityFragment(): ResultIdentityFragment
}