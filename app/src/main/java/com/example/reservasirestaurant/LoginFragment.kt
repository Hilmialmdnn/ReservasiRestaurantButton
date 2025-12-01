package com.example.reservasirestaurant

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.reservasirestaurant.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- Toggle ke Registrasi ---
        binding.btnRegistrasi.setOnClickListener {
            // Panggil fungsi di AuthActivity untuk menukar Fragment
            (activity as AuthActivity).showFragment(RegistrasiFragment())
        }

        // --- Proses Login ---
        binding.btnSubmit.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Email dan Password harus diisi.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Lakukan proses autentikasi ke backend/API di sini!

            // SIMULASI LOGIN BERHASIL:
            if (email == "dzakilybesn@gmail.com" && password == "12345678") {
                Toast.makeText(context, "Login Berhasil! Selamat datang.", Toast.LENGTH_SHORT).show()

                // Pindah ke MainActivity (asumsi ini halaman utama/Beranda)
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                activity?.finish() // Tutup AuthActivity
            } else {
                Toast.makeText(context, "Email atau Password salah.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}