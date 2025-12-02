package com.example.reservasirestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MenuListFragment : Fragment(R.layout.fragment_menu_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDrinks = view.findViewById<View>(R.id.btnDrinks)

        btnDrinks.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, DrinksFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
