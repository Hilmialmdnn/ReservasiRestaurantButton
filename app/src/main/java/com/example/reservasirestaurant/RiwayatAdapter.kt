package com.example.reservasirestaurant


import ReservasiData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.reservasirestaurant.databinding.ItemRiwayatBinding

class RiwayatAdapter(private val riwayatList: List<ReservasiData>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    inner class RiwayatViewHolder(private val binding: ItemRiwayatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ReservasiData) {
            binding.tvRuanganMeja.text = data.ruangan
            binding.tvTanggalWaktu.text = "${data.tanggalKedatangan} • ${data.waktu}"
            binding.tvJumlahOrang.text = "${data.jumlahOrang} Orang"
            binding.tvTipeReservasi.text = data.listMenu
            binding.tvStatusTeks.text = data.status

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

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        holder.bind(riwayatList[position])
    }

    override fun getItemCount(): Int = riwayatList.size
}