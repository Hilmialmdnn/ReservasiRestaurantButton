package com.example.reservasirestaurant

import ReservasiData
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Locale

class ReservasiFragment : Fragment(R.layout.fragment_reservasi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMenuList = view.findViewById<View>(R.id.btnMenuList)
        val btnPesan = view.findViewById<View>(R.id.btnPesan)


        val jumlahorang = view.findViewById<RadioGroup>(R.id.jumlahorang)
        val pilihruangan = view.findViewById<RadioGroup>(R.id.pilihruangan)


        val editTanggal = view.findViewById<EditText>(R.id.editTanggal)
        val editNama = view.findViewById<EditText>(R.id.editNama)
        val editWaktu = view.findViewById<EditText>(R.id.editWaktu)


        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("EEEE, d MMMM yyyy", Locale("id", "ID"))

        editTanggal.setText(sdf.format(calendar.time))

        editTanggal.setOnClickListener {
            val datePicker = DatePickerDialog(
                requireActivity(),
                { _, year, month, day ->
                    val cal = Calendar.getInstance()
                    cal.set(year, month, day)
                    editTanggal.setText(sdf.format(cal.time))
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        btnPesan.setOnClickListener {

            val namaLengkap = editNama.text.toString().trim()
            val tanggal = editTanggal.text.toString().trim()
            val waktu = editWaktu.text.toString().trim()

            val selectedIdOrang = jumlahorang.checkedRadioButtonId
            val selectedIdRuangan = pilihruangan.checkedRadioButtonId

            if (selectedIdOrang == -1 || selectedIdRuangan == -1) {
                Toast.makeText(requireContext(), "Harap pilih jumlah orang dan ruangan!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRbOrang = view.findViewById<RadioButton>(selectedIdOrang)
            val selectedRbRuangan = view.findViewById<RadioButton>(selectedIdRuangan)

            val jumlahOrang = selectedRbOrang.text.toString()
            val ruangan = selectedRbRuangan.text.toString()

            if (namaLengkap.isBlank() || tanggal.isBlank() || waktu.isBlank()) {
                Toast.makeText(requireContext(), "Nama, Tanggal, dan Waktu wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newReservasi = ReservasiData(
                namaLengkap = namaLengkap,
                tanggalKedatangan = tanggal,
                waktu = waktu,
                listMenu = view.findViewById<EditText>(R.id.editMenu).text.toString().trim().ifBlank { "Tidak Ada" },
                jumlahOrang = jumlahOrang,
                ruangan = ruangan,

                status = "Menunggu Konfirmasi"
            )

            TempReservasiData.addReservasi(newReservasi)

            navigateToKonfirmasi()
        }

        btnMenuList.setOnClickListener {
            navigateToMenulist()
        }
    }

    private fun navigateToMenulist() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, MenuListFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToKonfirmasi() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, KonfirmasiFragment())
            .addToBackStack(null)
            .commit()
    }
}
