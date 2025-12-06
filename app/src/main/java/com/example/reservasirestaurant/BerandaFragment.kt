package com.example.reservasirestaurant

import OnItemClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BerandaFragment : Fragment(), OnItemClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnIndoor = view.findViewById<View>(R.id.btnIndoor,)
       val  btnOudoor = view.findViewById<View>(R.id.btnOutdoor)
       val btnVvip = view.findViewById<View>(R.id.btnVvip)

       btnIndoor.setOnClickListener {
           navigateToReservasi()
       }
       btnOudoor.setOnClickListener {
           navigateToReservasi()
       }
       btnVvip.setOnClickListener {
           navigateToReservasi()
       }
    }

    private fun navigateToReservasi() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, ReservasiFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onBookButtonClick(room: Room) {
        navigateToReservasi()
    }
}
