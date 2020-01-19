package com.example.projet.di

import androidx.lifecycle.ViewModel
import com.example.projet.ui.dashboard.birth.ResultIdentityViewModel
import com.example.projet.ui.dashboard.birth.SearchIdentityViewModel
import com.example.projet.ui.dashboard.bulletin.BulletinViewModel
import com.example.projet.ui.dashboard.bulletin.search.SearchBulletinViewModel
import com.example.projet.ui.dashboard.revenue.RevenueViewModel
import com.example.projet.ui.dashboard.revenue.details.DetailRevenueViewModel
import com.example.projet.ui.dashboard.revenue.search.SearchRevenueViewModel
import com.example.projet.ui.onboarding.OnBoardingViewModel
import com.example.projet.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(OnBoardingViewModel::class)
    internal abstract fun bindOnBoardingActivity(onBoardingViewModel: OnBoardingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashActivity(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchIdentityViewModel::class)
    internal abstract fun bindBirthActivity(birthViewModel: SearchIdentityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RevenueViewModel::class)
    internal abstract fun bindRevenueActivity(revenueViewModel: RevenueViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailRevenueViewModel::class)
    internal abstract fun bindDetailRevenue(detailRevenueViewModel: DetailRevenueViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ResultIdentityViewModel::class)
    internal abstract fun bindResultIdentity(resultIdentityViewModel: ResultIdentityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchRevenueViewModel::class)
    internal abstract fun bindSearchRevenueViewModel(searchRevenueViewModel: SearchRevenueViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchBulletinViewModel::class)
    internal abstract fun bindSearchBulletinViewModel(searchBulletinViewModel: SearchBulletinViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BulletinViewModel::class)
    internal abstract fun bindBulletinViewModel(bulletinViewModel: BulletinViewModel): ViewModel


}