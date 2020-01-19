package com.example.projet.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.Observer
import com.example.projet.R
import com.example.projet.adapters.OnBoardingViewPagerAdapter
import com.example.projet.di.factory.AppViewModelFactory
import com.example.projet.extensions.vm
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_on_boarding.*
import javax.inject.Inject
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.projet.ui.dashboard.MainActivity

class OnBoardingActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel by lazy { vm(viewModelFactory, OnBoardingViewModel::class) }
    private lateinit var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        viewModel.getScreens()
        // listenner to observe list
        viewModel.mutableLiveData.observe(this, Observer {
            if (it != null) {
                onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(it.screens)
                screen_viewpager.adapter = onBoardingViewPagerAdapter
                tab_indicator.setupWithViewPager(screen_viewpager)
                tv_skip.setOnClickListener { _ ->
                    screen_viewpager.currentItem = it.screens.size
                }
            }
        })
        viewModel.errorState.observe(this, Observer { throwable ->
            throwable?.let {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        })
        // listenner when slide viewoager
        screen_viewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                // Check if this is the page you want.
                if (position < onBoardingViewPagerAdapter.count) {
                    screen_viewpager.currentItem = position
                }
                if (position == onBoardingViewPagerAdapter.count - 1) loadLastScreen() else {
                    btn_get_started.visibility = View.INVISIBLE
                }
            }
        })
        //listenner to click btn getStarted
        btn_get_started.setOnClickListener {
            val preferences = this.getSharedPreferences("prefs", 0)
            preferences.edit {
                putBoolean("onBoarding", true)
                commit()
            }
            openMainActivity()
        }
    }

    /**
     * open signin activity
     */
    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * load last screen
     */
    private fun loadLastScreen() {
        btn_get_started.visibility = View.VISIBLE
        tv_skip.visibility = View.INVISIBLE
        // setup animation
        btn_get_started.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.button_animation)
    }
}
