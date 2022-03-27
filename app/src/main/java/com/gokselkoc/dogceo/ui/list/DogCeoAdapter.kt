package com.gokselkoc.dogceo.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.dogceo.databinding.DogViewholderBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DogCeoAdapter(
    var list: ArrayList<String>,
    private val viewModel: DogCeoViewModel
) :
    RecyclerView.Adapter<DogCeoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DogViewholderBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, viewModel)
    }
    fun updateAdapter(newList: ArrayList<String>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(
        private val binding: DogViewholderBinding,
        private val dogCeoViewModel: DogCeoViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.model = item
            binding.viewModel = dogCeoViewModel
            binding.executePendingBindings()
        }

    }
}