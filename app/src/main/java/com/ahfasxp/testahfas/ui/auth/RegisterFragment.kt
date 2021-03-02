package com.ahfasxp.testahfas.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.ui.ViewModelFactory
import com.ahfasxp.testahfas.core.utils.SessionManager
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
    private lateinit var authViewModel: AuthViewModel
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]
            sessionManager = SessionManager(activity!!)

            btn_register.setOnClickListener {
                register()
            }
        }
    }

    private fun register() {
        authViewModel.postRegister(
            edt_name.text.toString(),
            edt_email.text.toString(),
            edt_password.text.toString()
        ).observe(viewLifecycleOwner, { user ->
            if (user != null) {
                sessionManager.saveAuthToken(user.apiToken)
                view?.findNavController()
                    ?.navigate(R.id.action_registerFragment_to_homeFragment)
            } else {
                view?.findNavController()
                    ?.navigate(R.id.action_loginFragment_to_registerFragment)
            }
        })
    }
}