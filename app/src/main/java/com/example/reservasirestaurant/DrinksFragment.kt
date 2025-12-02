package com.example.reservasirestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class DrinksFragment : Fragment(R.layout.fragment_drinks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnKembaliReservasi = view.findViewById<View>(R.id.btnKembaliReservasi)

        btnKembaliReservasi.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, ReservasiFragment())
                .addToBackStack(null)
                .commit()

        }
    }
}
