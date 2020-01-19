package com.example.projet.ui.dashboard.birth

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchIdentityFragmentProvider {
    @ContributesAndroidInjector(modules = [BirthModule::class])
    internal abstract fun provideBirthFirstStepFragmentFactory(): SearchIdentityFragment
}