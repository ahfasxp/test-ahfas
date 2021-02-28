package com.ahfasxp.testahfas.ui.tryout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahfasxp.testahfas.R
import com.ahfasxp.testahfas.core.data.Resource
import com.ahfasxp.testahfas.core.ui.MainAdapter
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

            val mainAdapter = MainAdapter()
            val factory = ViewModelFactory.getInstance(requireActivity())
            tryoutViewModel = ViewModelProvider(this, factory)[TryoutViewModel::class.java]

            tryoutViewModel.getTryouts.observe(viewLifecycleOwner, { tryouts ->
                if (tryouts != null) {
                    when (tryouts) {
                        is Resource.Loading -> progressbar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progressbar.visibility = View.GONE
                            mainAdapter.setData(tryouts.data)
                        }
                        is Resource.Error -> {
                            progressbar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(rv_tryouts) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mainAdapter
            }

            mainAdapter.onItemClick = { selectedData ->

            }
        }
    }

}