package com.example.testgeekspro.presentation.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testgeekspro.data.model.CarsModel
import com.example.testgeekspro.databinding.ItemCarsBinding

class MainAdapter(
    private var carList: List<CarsModel>,
    private val onClick: (model: CarsModel) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
     inner class ViewHolder(private val binding: ItemCarsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: CarsModel) = with(binding) {
            tvCarName.text = car.make
            tvCarYear.text = car.year
            imgCars.load(car.image)
            itemView.setOnClickListener() {
                onClick(car)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCarsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carList[position])
    }
}