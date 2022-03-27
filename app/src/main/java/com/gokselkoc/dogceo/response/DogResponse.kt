package com.gokselkoc.dogceo.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DogResponse(
    @JsonProperty("message")
    val message: DogPopulation?,
    @JsonProperty("status")
    val status: String?,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class DogPopulation(
    @JsonProperty("hound")
    val hound: ArrayList<String>?,
    @JsonProperty("bulldog")
    val bulldog: ArrayList<String>?,
)
