package com.example.reservasirestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class KonfirmasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_konfirmasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnKembali = view.findViewById<Button>(R.id.btn_kembali)

        val btnCekPesanan = view.findViewById<Button>(R.id.btn_cek_pesanan)

        btnKembali.setOnClickListener {
            navigateToBeranda()
        }

        btnCekPesanan.setOnClickListener {
            navigateToRiwayat()
        }
    }

    private fun navigateToBeranda() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, BerandaFragment())
            .commit()
    }
    private fun navigateToRiwayat() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, RiwayatFragment())
            .addToBackStack(null)
            .commit()
    }
}