package com.example.projet.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.projet.R
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.ui.dashboard.MainActivity
import com.example.projet.ui.onboarding.OnBoardingActivity
import com.example.projet.extensions.vm
import dagger.android.AndroidInjection
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, SplashViewModel::class) }
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(
            {
                val preferences = this.getSharedPreferences("prefs", 0)
                val isOnBoarding = preferences.getBoolean("onBoarding", false)
                if (isOnBoarding) {
                    goToMainActivity()
                } else {
                    goToOnBoardingActivity()
                }
            },
            3000 // value in milliseconds
        )
    }


    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun goToOnBoardingActivity() {
        finish()
        startActivity(Intent(this, OnBoardingActivity::class.java))
    }
}
