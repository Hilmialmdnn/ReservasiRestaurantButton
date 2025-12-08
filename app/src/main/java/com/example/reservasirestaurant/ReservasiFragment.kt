package com.example.reservasirestaurant

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.Locale

class ReservasiFragment : Fragment(R.layout.fragment_reservasi) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMenuList = view.findViewById<View>(R.id.btnMenuList)
        val btnPesan = view.findViewById<View>(R.id.btnPesan)

        // EditText Tanggal
        val editTanggal = view.findViewById<EditText>(R.id.editTanggal)

        // Calendar + Formatter
        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("EEEE, d MMMM yyyy", Locale("id", "ID"))

        // Isi default tanggal saat ini
        editTanggal.setText(sdf.format(calendar.time))

        // Buka date picker saat klik editTanggal
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
