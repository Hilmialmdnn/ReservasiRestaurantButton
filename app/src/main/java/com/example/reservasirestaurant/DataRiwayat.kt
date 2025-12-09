package com.example.reservasirestaurant

data class DataRiwayat(
    val ruanganMeja: String,
    val tanggal: String,
    val waktu: String,
    val jumlahOrang: Int,
    val tipeReservasi: String,
    val status: String
)