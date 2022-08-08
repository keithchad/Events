package com.upcomingevents.events.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upcomingevents.events.R
import com.upcomingevents.events.databinding.FragmentEventAddBinding
import com.upcomingevents.events.databinding.UnsplashItemBinding
import com.upcomingevents.events.model.Unsplash

class UnsplashAdapter(var list: List<Unsplash>, var context: Context) : RecyclerView.Adapter<UnsplashAdapter.ViewHolder>() {

    lateinit var unsplashItemBinding: UnsplashItemBinding
    val binding get() = unsplashItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val unsplashItemBinding  = UnsplashItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(unsplashItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val unsplash = list[position]
        holder.setData(unsplash)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(var binding: UnsplashItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(unsplash: Unsplash) {
            Glide.with(context).load(unsplash.imageUrl).into(binding.unsplashImage)
        }
    }
}