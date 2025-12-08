package com.example.reservasirestaurant

// Hapus import 'ReservasiData' yang berdiri sendiri jika ReservasiData berada di package yang sama

import ReservasiData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.databinding.ItemRiwayatBinding

// PERBAIKAN 1: Ganti List<DataRiwayat> menjadi List<ReservasiData>
class RiwayatAdapter(private val riwayatList: List<ReservasiData>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    inner class RiwayatViewHolder(private val binding: ItemRiwayatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ReservasiData) {
            // PERBAIKAN 3 (Asumsi): Menggunakan data.pilihanRuangan
            binding.tvRuanganMeja.text = data.ruangan
            binding.tvTanggalWaktu.text = "${data.tanggalKedatangan} • ${data.waktu}" // Menggunakan waktuKedatangan
            binding.tvJumlahOrang.text = "${data.jumlahOrang} Orang"
            binding.tvTipeReservasi.text = data.listMenu
            binding.tvStatusTeks.text = data.status

            // Logika pewarnaan status
            val color: Int = when (data.status) {
                "Berhasil" -> ContextCompat.getColor(binding.root.context, R.color.green_success)
                "Dibatalkan" -> ContextCompat.getColor(binding.root.context, R.color.red_cancel)
                else -> ContextCompat.getColor(binding.root.context, R.color.orange_pending)
            }
            binding.tvStatusTeks.setTextColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val binding = ItemRiwayatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RiwayatViewHolder(binding)
    }

    // PERBAIKAN 2: Tambahkan fungsi wajib onBindViewHolder yang hilang
    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        // Panggil fungsi bind di View Holder Anda
        holder.bind(riwayatList[position])
    }

    override fun getItemCount(): Int = riwayatList.size
}