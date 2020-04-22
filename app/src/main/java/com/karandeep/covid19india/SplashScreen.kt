package com.karandeep.covid19india

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(
                {
                    val i = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }, SPLASH_TIME_OUT)
    }
}