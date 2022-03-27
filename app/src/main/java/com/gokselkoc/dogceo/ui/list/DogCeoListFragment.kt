package com.gokselkoc.dogceo.ui.list

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.gokselkoc.dogceo.base.BaseFragment
import com.gokselkoc.dogceo.R
import com.gokselkoc.dogceo.const.Keys
import com.gokselkoc.dogceo.databinding.FragmentDogCeoListBinding
import com.gokselkoc.dogceo.extension.navigateSafe
import com.gokselkoc.dogceo.extension.observe
import com.gokselkoc.dogceo.response.DogResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DogCeoListFragment :BaseFragment<FragmentDogCeoListBinding>(R.layout.fragment_dog_ceo_list){

    private val viewModel by viewModels<DogCeoViewModel>()

    private val dogCeoListAdapter: DogCeoAdapter by lazy {
        DogCeoAdapter(
            ArrayList(),
            viewModel
        )
    }

    override fun FragmentDogCeoListBinding.initialize() {
        observe(viewModel.dogResponse,::onDogResponseChanged)
        observe(viewModel.clickedDog,::onClickedDog)

    }

    private fun onClickedDog(data: String) {


        val bundle=Bundle().apply {
            putString(Keys.dogName,data)
        }
        navigateSafe(resId = R.id.action_dogCeoListFragment_to_dogDetailFragment, bundle = bundle)
    }

    private fun onDogResponseChanged(dogResponse: DogResponse) {
        dogResponse.message?.bulldog?.let {
            dogCeoListAdapter.updateAdapter(it) }
            binding.addressesRecyclerView.adapter = dogCeoListAdapter
        }
    }

