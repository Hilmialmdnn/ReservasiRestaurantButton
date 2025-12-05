package com.example.reservasirestaurant

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.databinding.ItemRiwayatBinding

class RiwayatAdapter(private val riwayatList: List<DataRiwayat>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    inner class RiwayatViewHolder(private val binding: ItemRiwayatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataRiwayat) {
            binding.tvRuanganMeja.text = data.ruanganMeja
            binding.tvTanggalWaktu.text = "${data.tanggal} • ${data.waktu}"
            binding.tvJumlahOrang.text = "${data.jumlahOrang} Orang"
            binding.tvTipeReservasi.text = data.tipeReservasi
            binding.tvStatusTeks.text = data.status

            // Logika pewarnaan status
            val color: Int = when (data.status) {
                "Berhasil" -> ContextCompat.getColor(binding.root.context, R.color.green_success) // Ganti dengan warna hijau kamu
                "Dibatalkan" -> ContextCompat.getColor(binding.root.context, R.color.red_cancel) // Ganti dengan warna merah kamu
                else -> ContextCompat.getColor(binding.root.context, R.color.orange_pending) // Ganti dengan warna oranye kamu
            }
            binding.tvStatusTeks.setTextColor(color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val binding = ItemRiwayatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RiwayatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        holder.bind(riwayatList[position])
    }

    override fun getItemCount(): Int = riwayatList.size
}