object TempReservasiData {
    // List yang akan menampung riwayat reservasi
    val riwayatList = mutableListOf<ReservasiData>()

    fun addReservasi(data: ReservasiData) {
        riwayatList.add(data)
    }
}