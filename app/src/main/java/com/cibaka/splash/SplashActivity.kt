package com.cibaka.splash

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.cibaka.R
import com.cibaka.auth.AuthenticationActivity
import com.cibaka.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val TAG = SplashActivity::class.simpleName
    private var _binding: ActivitySplashBinding? = null
    private var mActivity: Activity? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        init()
    }

    private fun init() {
        mActivity = this

        Handler().postDelayed({
            val intent = Intent(mActivity!!, AuthenticationActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}