package com.example.projet.ui.dashboard.birth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.projet.R
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.vm
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class BirthActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    //private val viewModel by lazy { vm(viewModelFactory, SearchIdentityViewModel::class) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birth)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.my_nav_host_fragment).navigateUp()

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


    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
