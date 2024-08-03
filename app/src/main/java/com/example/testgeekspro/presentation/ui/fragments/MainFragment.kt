package com.example.testgeekspro.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.testgeekspro.R
import com.example.testgeekspro.data.model.CarsModel
import com.example.testgeekspro.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val carsList = arrayListOf(
        CarsModel("Audi","1987","https://www.autostat.ru/application/includes/blocks/big_photo/images/cache/000/116/597/494654e1-670-0.jpg"),
        CarsModel("Mers","2000","https://mercedes-benz-uzbekistan.uz/wp-content/uploads/2022/02/1167f.webp"),
        CarsModel("BMW","2004","https://www.bmw.kg/content/dam/bmw/common/all-models/m-series/series-overview/bmw-m-series-seo-overview-ms-04.jpg"),
        CarsModel("Porshe","1996","https://vukasin772.wordpress.com/wp-content/uploads/2017/05/porse1.jpg?w=600"),
        CarsModel("Lamborghini","2011","https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/facelift_2019/model_gw/aventador/2023/02_09_refresh/aven_gate_s_02_m.jpg"),
        CarsModel("Niva","1800","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPOI-d1YgjpZIibux0SsbJVRCMYGmDb9h3UQ&s"),
        CarsModel("Tayota","1999","https://s.alicdn.com/@sc04/kf/Ha9f8a6f834e949148ab0ff04ceb280ac7.jpg_300x300.jpg"),
        CarsModel("Lx","1999","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsKT1GHImLk2ychQ2vWqfpTn3dAWnF5mKKRQ&s"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = MainAdapter(carsList, this::onClick)
    }

    private fun onClick(carsModel: CarsModel) {
        findNavController().navigate(R.id.detailFragment2, bundleOf(Keys.KEY_FOR_CAR to carsModel))
    }
}

object Keys {
    const val KEY_FOR_CAR = "key_for_car"
}