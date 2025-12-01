package com.example.reservasirestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ReservasiFragment : Fragment(R.layout.fragment_reservasi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMenuList = view.findViewById<View>(R.id.btnMenuList)

        btnMenuList.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, MenuListFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
