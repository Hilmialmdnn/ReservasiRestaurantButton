package com.example.reservasirestaurant

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.reservasirestaurant.databinding.FragmentReservasiBinding
import java.text.SimpleDateFormat
import java.util.*

class ReservasiFragment : Fragment() {

    private var _binding: FragmentReservasiBinding? = null
    // Menggunakan ViewBinding
    private val binding get() = _binding!!

    // Format untuk menampilkan tanggal dan waktu
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inisialisasi ViewBinding
        _binding = FragmentReservasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup Date Picker
        binding.etTanggal.setOnClickListener {
            showDatePicker()
        }

        // 2. Setup Time Picker
        binding.etWaktu.setOnClickListener {
            showTimePicker()
        }

        // 3. Konfirmasi Reservasi
        binding.btnKonfirmasiReservasi.setOnClickListener {
            processReservasi()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                calendar.set(selectedYear, selectedMonth, selectedDay)
                binding.etTanggal.setText(dateFormat.format(calendar.time))
            }, year, month, day)

        // Batasi hanya bisa memilih tanggal hari ini atau setelahnya
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
        datePickerDialog.show()
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(requireContext(),
            { _, selectedHour, selectedMinute ->
                calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
                calendar.set(Calendar.MINUTE, selectedMinute)
                binding.etWaktu.setText(timeFormat.format(calendar.time))
            }, hour, minute, true) // true = format 24 jam

        timePickerDialog.show()
    }

    private fun processReservasi() {
        val tanggal = binding.etTanggal.text.toString()
        val waktu = binding.etWaktu.text.toString()
        val jumlahOrangStr = binding.etJumlahOrang.text.toString()

        val selectedRuanganId = binding.radioGroupRuangan.checkedRadioButtonId

        // 1. Validasi Input
        if (tanggal.isEmpty() || waktu.isEmpty() || jumlahOrangStr.isEmpty() || selectedRuanganId == -1) {
            Toast.makeText(context, "Mohon lengkapi semua data reservasi.", Toast.LENGTH_SHORT).show()
            return
        }

        val jumlahOrang = jumlahOrangStr.toIntOrNull()
        if (jumlahOrang == null || jumlahOrang < 1 || jumlahOrang > 10) {
            Toast.makeText(context, "Jumlah tamu harus antara 1 sampai 10 orang.", Toast.LENGTH_SHORT).show()
            return
        }

        val ruangan = view?.findViewById<RadioButton>(selectedRuanganId)?.text.toString()

        // 2. Tampilkan Konfirmasi (SIMULASI)
        val pesan = "Reservasi untuk $jumlahOrang orang di $ruangan pada $tanggal, jam $waktu telah dikonfirmasi."
        Toast.makeText(context, pesan, Toast.LENGTH_LONG).show()

        // TODO: Lakukan proses penyimpanan reservasi ke database/API backend di sini!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}