package com.example.projet.ui.dashboard.bulletin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.projet.R
import com.example.projet.di.factory.AppViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class BulletinActivity : AppCompatActivity(), HasSupportFragmentInjector {


    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bulletin)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector


    override fun onBackPressed() {
        val hostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment)
        if (hostFragment is NavHostFragment) {
            val currentFragment = hostFragment.childFragmentManager.fragments.first()
            if (currentFragment is ComplexBackPressFragment) {
                currentFragment.handleBackPress()

            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }

    }

    interface ComplexBackPressFragment {
        fun handleBackPress()
    }
}
