package com.example.doctorapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PatientRetrofit
{
    var baseURL = "http://localhost:3000/patient/"

    private val retrofitBuilder = Retrofit

        .Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // The Api instance
    val patientApi = retrofitBuilder.create(PatientService::class.java)

}