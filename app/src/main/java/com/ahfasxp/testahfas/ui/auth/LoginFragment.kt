package com.ahfasxp.testahfas.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.ui.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]

            val edtEmail = "admin@mail.com"
            val edtPassword = "admin123"
            btn_login.setOnClickListener {
                authViewModel.postLogin(edtEmail, edtPassword)
                    .observe(viewLifecycleOwner, { user ->
                        if (user != null) {
                            view.findNavController()
                                .navigate(R.id.action_loginFragment_to_homeFragment)
                        } else {
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    })
            }
            btn_register.setOnClickListener {
                view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }
}