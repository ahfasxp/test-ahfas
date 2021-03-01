package com.ahfasxp.testahfas.ui.materi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.ui.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_materi.*

class MateriFragment : Fragment() {
    private lateinit var materiViewModel: MateriViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_materi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val materiAdapter = MateriAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            materiViewModel = ViewModelProvider(this, factory)[MateriViewModel::class.java]

            materiViewModel.getMateries.observe(viewLifecycleOwner, { materies ->
                if (materies != null) {
                    materiAdapter.setData(materies)
                }
            })

            with(rv_materies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = materiAdapter
            }

            materiAdapter.onItemClick = { selectedData ->

            }
        }
    }
}