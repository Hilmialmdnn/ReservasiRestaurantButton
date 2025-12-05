package com.example.reservasirestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reservasirestaurant.databinding.FragmentRiwayatBinding

class RiwayatFragment : Fragment() {

    private var _binding: FragmentRiwayatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Buat data dummy (sesuai mockup)
        val dataList = listOf(
            DataRiwayat(
                ruanganMeja = "Ruangan VIP – Meja 03",
                tanggal = "12 Desember 2025",
                waktu = "19:00 WIB",
                jumlahOrang = 4,
                tipeReservasi = "Reservasi Online",
                status = "Berhasil"
            ),
            DataRiwayat(
                ruanganMeja = "Outdoor Area – Meja 07",
                tanggal = "10 Desember 2025",
                waktu = "17:30 WIB",
                jumlahOrang = 2,
                tipeReservasi = "Reservasi Offline",
                status = "Dibatalkan"
            ),
            DataRiwayat(
                ruanganMeja = "Indoor – Meja 11",
                tanggal = "08 Desember 2025",
                waktu = "20:00 WIB",
                jumlahOrang = 5,
                tipeReservasi = "Reservasi Online",
                status = "Menunggu Konfirmasi"
            )
        )

        // 2. Setup RecyclerView
        val riwayatAdapter = RiwayatAdapter(dataList)
        binding.rvRiwayat.layoutManager = LinearLayoutManager(context)
        binding.rvRiwayat.adapter = riwayatAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}