package com.gokselkoc.dogceo.api

import com.gokselkoc.dogceo.response.DogResponse
import retrofit2.http.GET

interface DogCeoApiService {

    @GET("breeds/list/all")
    suspend fun getDogList(): DogResponse
}