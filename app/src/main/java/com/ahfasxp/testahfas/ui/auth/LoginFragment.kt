package com.ahfasxp.testahfas.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ahfasxp.testahfas.R
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

        btn_login.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        btn_register.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}