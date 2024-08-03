package com.example.testgeekspro.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.testgeekspro.R
import com.example.testgeekspro.data.model.CarsModel
import com.example.testgeekspro.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        val model = arguments?.getSerializable(Keys.KEY_FOR_CAR) as CarsModel
        binding.apply {
            tvCarName.text = model.make
            tvCarYear.text = model.year
            imgCars.load(model.image)
        }
    }

}