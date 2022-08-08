package com.upcomingevents.events.fragment

import android.app.DatePickerDialog
import android.os.Build
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
import java.text.SimpleDateFormat
import java.util.*

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

        val calender = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{ _, year, month, dayOfMonth ->
            calender.set(Calendar.YEAR, year)
            calender.set(Calendar.MONTH, month)
            calender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateEditText(calender)
        }

        binding.buttonDate.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                DatePickerDialog(
                    requireActivity(), datePicker, calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        return binding.root
    }

    private fun updateEditText(calender: Calendar) {
        val format = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(format, Locale.US)
        binding.buttonDate.text = sdf.format(calender.time)
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