package com.gokselkoc.dogceo.repositories

import com.gokselkoc.dogceo.api.DogCeoApiService
import com.gokselkoc.dogceo.resource.Resource
import com.gokselkoc.dogceo.response.DogResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ExperimentalCoroutinesApi
class DogCeoRepository @Inject constructor(
    private val dogCeoApiService: DogCeoApiService) {

    fun getDogList(): Flow<Resource<DogResponse>> {

        return flow {
            emit(Resource.loading(null))
            val dogResponse = dogCeoApiService.getDogList()
            emit(Resource.success(data = dogResponse))
        }.catch {
            emit(Resource.error(it.localizedMessage,null))
        }.flowOn(Dispatchers.IO)

    }
}