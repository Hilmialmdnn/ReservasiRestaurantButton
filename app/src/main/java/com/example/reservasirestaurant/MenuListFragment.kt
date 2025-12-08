package com.example.reservasirestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.adapters.MenuAdapter
import com.example.reservasirestaurant.models.MenuModel

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

        val recyclerMenu = view.findViewById<RecyclerView>(R.id.recyclerMenu)

        val listMenu = listOf(
            MenuModel("Chicken Skin", "Rp12.500", R.drawable.chikenskin),
            MenuModel("Gorengan Keranjang", "Rp8.000", R.drawable.gorengan),
            MenuModel("French Fries Mayo", "Rp8.500", R.drawable.french),
            MenuModel("Calamary", "Rp10.000", R.drawable.calamary),
            MenuModel("Onion Ring", "Rp15.000", R.drawable.onion),
            MenuModel("Cheese French Fries", "Rp20.000", R.drawable.kentangkeju),
            MenuModel("Ice Cream Goreng", "Rp15.000", R.drawable.icegoreng),
            MenuModel("Cireng", "Rp5.000", R.drawable.cireng),
            MenuModel("Zaitun Kaya Toast", "Rp15.000", R.drawable.zaitunkayatoast),
            MenuModel("Zaitun Fritter", "Rp25.000", R.drawable.zaitunfritte),
        )

        recyclerMenu.layoutManager = LinearLayoutManager(requireContext())
        recyclerMenu.adapter = MenuAdapter(listMenu)
    }
}
