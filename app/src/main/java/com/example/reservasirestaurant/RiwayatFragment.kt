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

        // 1. Ambil Data NYATA dari penyimpanan sementara (TempReservasiData)
        val riwayatDataAsli = TempReservasiData.riwayatList

        // 2. Setup RecyclerView
        // PENTING: Gunakan requireContext() untuk LayoutManager, karena 'context' mungkin null
        val riwayatAdapter = RiwayatAdapter(riwayatDataAsli)
        binding.rvriwayat.layoutManager = LinearLayoutManager(requireContext()) // <-- Perbaikan 1
        binding.rvriwayat.adapter = riwayatAdapter

        // 3. [PENTING] Logika Empty State
        if (riwayatDataAsli.isEmpty()) {
            // Tampilkan pesan kosong
            binding.tvEmptyState.visibility = View.VISIBLE
            binding.rvriwayat.visibility = View.GONE
        } else {
            // Tampilkan list riwayat
            binding.tvEmptyState.visibility = View.GONE
            binding.rvriwayat.visibility = View.VISIBLE
        }
    }

    // Perbaikan 2: Pastikan data adapter diperbarui jika Fragment di-resume (misalnya, kembali dari KonfirmasiFragment)
    override fun onResume() {
        super.onResume()
        // Panggil setup RecyclerView lagi untuk memuat data terbaru dari TempReservasiData
        setupRecyclerView()
    }

    // Pindahkan logika RecyclerView ke fungsi terpisah agar dapat dipanggil ulang
    private fun setupRecyclerView() {
        val riwayatDataAsli = TempReservasiData.riwayatList

        binding.rvriwayat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvriwayat.adapter = RiwayatAdapter(riwayatDataAsli)

        // Logika Empty State juga dipindahkan ke sini
        if (riwayatDataAsli.isEmpty()) {
            binding.tvEmptyState.visibility = View.VISIBLE
            binding.rvriwayat.visibility = View.GONE
        } else {
            binding.tvEmptyState.visibility = View.GONE
            binding.rvriwayat.visibility = View.VISIBLE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}