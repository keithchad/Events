package com.upcomingevents.events.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.upcomingevents.events.R
import com.upcomingevents.events.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}