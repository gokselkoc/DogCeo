package com.gokselkoc.dogceo.ui.detail


import com.gokselkoc.dogceo.R
import com.gokselkoc.dogceo.base.BaseFragment
import com.gokselkoc.dogceo.const.Keys
import com.gokselkoc.dogceo.databinding.FragmentDogDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DogDetailFragment : BaseFragment<FragmentDogDetailBinding>(R.layout.fragment_dog_detail) {

    override fun FragmentDogDetailBinding.initialize() {
        val dogName = arguments?.get(Keys.dogName) as String
        binding.dogName = dogName
    }
}