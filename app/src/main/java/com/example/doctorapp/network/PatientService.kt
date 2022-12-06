package com.example.doctorapp.network

import com.example.doctorapp.models.Patient
import retrofit2.Call
import retrofit2.http.*

interface PatientService
{
    @GET("patient")
    @Headers("")
    fun getPatientList(): Patient

    @GET("patient/{id}")
    @Headers("")
    fun getPatient(@Query("id") id: String): Patient

    @POST("patient")
    @Headers("")
    fun addPatient(@Body params: Patient): Patient

    @PATCH("patient/{id}")
    @Headers("")
    fun updatePatient(@Path("id") id: Int, @Body params: Patient): Patient

    @DELETE("patient/{id}")
    @Headers("")
    fun deletePatient(@Path("id") id: Int): Patient

}