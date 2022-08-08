package com.upcomingevents.events.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.upcomingevents.events.R
import com.upcomingevents.events.databinding.FragmentEventAddBinding

class EventAddFragment : Fragment() {

    lateinit var fragmentEventAddBinding: FragmentEventAddBinding
    val binding get() = fragmentEventAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEventAddBinding = FragmentEventAddBinding.inflate(inflater, container, false)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_eventAddFragment_to_eventDisplayFragment)
        }
        return binding.root
    }

}