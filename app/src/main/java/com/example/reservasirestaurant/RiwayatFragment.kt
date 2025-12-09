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

        val riwayatDataAsli = TempReservasiData.riwayatList

        val riwayatAdapter = RiwayatAdapter(riwayatDataAsli)
        binding.rvriwayat.layoutManager = LinearLayoutManager(requireContext()) // <-- Perbaikan 1
        binding.rvriwayat.adapter = riwayatAdapter

        if (riwayatDataAsli.isEmpty()) {
            binding.tvEmptyState.visibility = View.VISIBLE
            binding.rvriwayat.visibility = View.GONE
        } else {
            binding.tvEmptyState.visibility = View.GONE
            binding.rvriwayat.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val riwayatDataAsli = TempReservasiData.riwayatList

        binding.rvriwayat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvriwayat.adapter = RiwayatAdapter(riwayatDataAsli)

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