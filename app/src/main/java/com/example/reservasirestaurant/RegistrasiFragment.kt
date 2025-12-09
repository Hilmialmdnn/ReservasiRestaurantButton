package com.example.reservasirestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.reservasirestaurant.databinding.FragmentRegistrasiBinding

class RegistrasiFragment : Fragment() {

    private var _binding: FragmentRegistrasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            (activity as AuthActivity).showFragment(LoginFragment())
        }

        binding.btnSubmitReg.setOnClickListener {
            val email = binding.etEmailReg.text.toString().trim()
            val password = binding.etPasswordReg.text.toString().trim()
            val confirmPassword = binding.etConfirmPasswordReg.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(context, "Semua field harus diisi.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(context, "Password dan Konfirmasi Password tidak cocok.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Lakukan proses registrasi ke backend/API di sini!

            Toast.makeText(context, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_LONG).show()

            (activity as AuthActivity).showFragment(LoginFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}