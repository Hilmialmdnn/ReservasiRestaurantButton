package com.example.reservasirestaurant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.adapters.DrinksAdapter
import com.example.reservasirestaurant.DrinksModel

class DrinksFragment : Fragment(R.layout.fragment_drinks) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnKembali = view.findViewById<View>(R.id.btnKembalir)

        btnKembali.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, ReservasiFragment())
                .addToBackStack(null)
                .commit()
        }

        val recyclerDrinks = view.findViewById<RecyclerView>(R.id.recyclerDrinks)

        val listDrinks = listOf(
            DrinksModel("Es Teh", "Rp5.500", R.drawable.esteh),
            DrinksModel("Teh Tarik", "Rp8.000", R.drawable.tehtarik),
            DrinksModel("Susu Tape", "Rp10.500", R.drawable.susutape),
            DrinksModel("Americano", "Rp10.000", R.drawable.blend),
            DrinksModel("Kopi Kalcer", "Rp15.000", R.drawable.kopikalcer),
            DrinksModel("Kopi Butterscott", "Rp20.000", R.drawable.kopibutter),
            DrinksModel("Juz Mangga", "Rp15.000", R.drawable.juzmangga),
            DrinksModel("Juz Apel", "Rp5.000", R.drawable.juzapel),
            DrinksModel("Juz Jambu", "Rp15.000", R.drawable.juzjambu),
            DrinksModel("Juz Timun", "Rp25.000", R.drawable.juztimun),
        )

        recyclerDrinks.layoutManager = LinearLayoutManager(requireContext())
        recyclerDrinks.adapter = DrinksAdapter(listDrinks)
    }
}
