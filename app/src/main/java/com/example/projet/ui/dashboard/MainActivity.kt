package com.example.projet.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.projet.R
import com.example.projet.ui.dashboard.birth.BirthActivity
import com.example.projet.ui.dashboard.bulletin.BulletinActivity
import com.example.projet.ui.dashboard.revenue.RevenueActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom)
        bgapp.animate().translationY(-1900f).setDuration(1800).setStartDelay(300)
        textsplash.animate().translationY(140f).alpha(0f).setDuration(800).setStartDelay(300)
        texthome.startAnimation(fromBottom)
        menus.startAnimation(fromBottom)
        birth_layout.setOnClickListener {
            openBirthActivity()
        }
        revenue_lay.setOnClickListener {
            openRevenueActivity()
        }
        interior_layout.setOnClickListener {
            openMinistre()
        }
    }

    private fun openBirthActivity() {
        val intent = Intent(this, BirthActivity::class.java)
        startActivity(intent)
    }

    private fun openRevenueActivity() {
        val intent = Intent(this, RevenueActivity::class.java)
        startActivity(intent)
    }

    private fun openMinistre() {
        val intent = Intent(this, BulletinActivity::class.java)
        startActivity(intent)
    }
}
