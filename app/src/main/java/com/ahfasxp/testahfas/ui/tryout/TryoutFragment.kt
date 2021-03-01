package com.ahfasxp.testahfas.ui.tryout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.ui.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tryout.*

class TryoutFragment : Fragment() {
    private lateinit var tryoutViewModel: TryoutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tryout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val tryoutAdapter = TryoutAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            tryoutViewModel = ViewModelProvider(this, factory)[TryoutViewModel::class.java]

            tryoutViewModel.getTryouts.observe(viewLifecycleOwner, { tryouts ->
                if (tryouts != null) {
                    tryoutAdapter.setData(tryouts)
                }
            })

            with(rv_tryouts) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tryoutAdapter
            }

            tryoutAdapter.onItemClick = { selectedData ->

            }
        }
    }

}