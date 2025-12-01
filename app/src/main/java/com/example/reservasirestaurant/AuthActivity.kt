package com.example.reservasirestaurant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.reservasirestaurant.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memuat LoginFragment sebagai Fragment default saat Activity dibuat
        if (savedInstanceState == null) {
            showFragment(LoginFragment())
        }
    }

    /**
     * Fungsi publik untuk menukar Fragment di dalam container.
     */
    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}