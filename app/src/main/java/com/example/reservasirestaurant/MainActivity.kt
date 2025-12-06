package com.example.reservasirestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.reservasirestaurant.BerandaFragment
import com.example.reservasirestaurant.ReservasiFragment
import com.example.reservasirestaurant.RiwayatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // Menampilkan fragment Home pertama kali
        loadFragment(BerandaFragment())

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> loadFragment(BerandaFragment())
                R.id.nav_reservasi -> loadFragment(ReservasiFragment())
                R.id.nav_riwayat -> loadFragment(RiwayatFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, fragment)
            .commit()
    }
}


