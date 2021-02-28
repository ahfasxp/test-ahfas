package com.ahfasxp.testahfas.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ahfasxp.testahfas.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cv_materi.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_materiFragment)
        }
        cv_tryout.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_tryoutFragment)
        }
    }
}