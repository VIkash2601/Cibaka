package com.foundrytreasure.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.foundrytreasure.databinding.ActivityAuthenticationBinding

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_login_fragment, R.id.nav_register_fragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)*/
    }
}