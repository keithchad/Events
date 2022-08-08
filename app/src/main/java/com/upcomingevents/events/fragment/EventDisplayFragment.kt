package com.upcomingevents.events.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.upcomingevents.events.R
import com.upcomingevents.events.adapter.UnsplashAdapter
import com.upcomingevents.events.databinding.FragmentEventAddBinding
import com.upcomingevents.events.databinding.FragmentEventDisplayBinding
import com.upcomingevents.events.model.Unsplash

class EventDisplayFragment : Fragment() {

    private lateinit var fragmentEventDisplayBinding: FragmentEventDisplayBinding
    private val binding get() = fragmentEventDisplayBinding
    private lateinit var list: List<Unsplash>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEventDisplayBinding = FragmentEventDisplayBinding.inflate(inflater, container, false)
        populateData()
        setUpRecyclerView()



        return binding.root
    }

    private fun setUpRecyclerView() {
        val unsplashAdapter = UnsplashAdapter(list, requireActivity())
        binding.recyclerViewUnsplash.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerViewUnsplash.adapter = unsplashAdapter
    }

    private fun populateData() {
        list = arrayListOf(
            Unsplash(1, R.drawable.u1),
            Unsplash(1, R.drawable.u2),
            Unsplash(1, R.drawable.u3),
            Unsplash(1, R.drawable.u4),
            Unsplash(1, R.drawable.u5),
            Unsplash(1, R.drawable.u6),
            Unsplash(1, R.drawable.u7),
            Unsplash(1, R.drawable.u8),
            Unsplash(1, R.drawable.u9)
        )
    }

}