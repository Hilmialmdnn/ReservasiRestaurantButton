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
        // Inflate layout menggunakan R.layout.fragment_konfirmasi
        // Catatan: Pastikan Anda sudah membuat fragment_konfirmasi.xml
        return inflater.inflate(R.layout.fragment_konfirmasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- MENGGUNAKAN findViewById UNTUK MENDAPATKAN TOMBOL ---

        // Dapatkan referensi tombol Kembali (menggunakan ID dari XML Anda)
        val btnKembali = view.findViewById<Button>(R.id.btn_kembali)

        // Dapatkan referensi tombol Cek Pesanan
        val btnCekPesanan = view.findViewById<Button>(R.id.btn_cek_pesanan)

        // Atur Listener Tombol
        btnKembali.setOnClickListener {
            navigateToBeranda()
        }

        btnCekPesanan.setOnClickListener {
            navigateToRiwayat()
        }
    }

    // Navigasi Manual ke Beranda
    private fun navigateToBeranda() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, BerandaFragment())
            .commit()
    }

    // Navigasi Manual ke Riwayat
    private fun navigateToRiwayat() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, RiwayatFragment())
            .addToBackStack(null)
            .commit()
    }

    // TIDAK perlu onDestroyView() di sini karena tidak ada View Binding untuk dibersihkan.
}