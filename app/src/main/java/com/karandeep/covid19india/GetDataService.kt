package com.karandeep.covid19india
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {
    @GET("/data.json")
    fun getinfo(): Call <statelist2>
}