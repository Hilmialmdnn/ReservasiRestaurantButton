object TempReservasiData {
    val riwayatList = mutableListOf<ReservasiData>()

    fun addReservasi(data: ReservasiData) {
        riwayatList.add(data)
    }
}