package com.example.myordermanager.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myordermanager.databinding.ActivityAuthenticationProcessBinding

class AuthenticationProcessActivity : AppCompatActivity() {


    private lateinit var binding: ActivityAuthenticationProcessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthenticationProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}