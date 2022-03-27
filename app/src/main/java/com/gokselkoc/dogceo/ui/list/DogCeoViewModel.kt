package com.gokselkoc.dogceo.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokselkoc.dogceo.enum.Status
import com.gokselkoc.dogceo.repositories.DogCeoRepository
import com.gokselkoc.dogceo.response.DogResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogCeoViewModel
@Inject constructor(private val dogCeoRepository: DogCeoRepository) : ViewModel() {


    private val _dogResponse = MutableLiveData<DogResponse>()
    val dogResponse: LiveData<DogResponse> = _dogResponse

    private val _clickedDog = MutableLiveData<String>()
    val clickedDog: LiveData<String> = _clickedDog

    init {
        getDogList()
    }

    fun onClickItem(data: String) {
        _clickedDog.value = data
    }


    private fun getDogList() {
        viewModelScope.launch {
            dogCeoRepository.getDogList().collect {

                if (it.status == Status.SUCCESS) {
                    it.let {
                        _dogResponse.value = it.data!!
                    }

                } else if (it.status == Status.ERROR) {
                    Log.e("Error", it.message.toString())
                }


            }
        }
    }
}