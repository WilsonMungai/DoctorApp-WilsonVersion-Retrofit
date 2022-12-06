package com.example.doctorapp.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctorapp.database.AppDatabase
import com.example.doctorapp.database.PatientDao
import com.example.doctorapp.models.PatientEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PatientRepository(application: Application) {
    val allPatients: LiveData<List<PatientEntity>>?
    val searchResults = MutableLiveData<List<PatientEntity>>()
    var db: AppDatabase? = null

    private var patientDao: PatientDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        db = AppDatabase.getInstance(application)
        patientDao = db?.patientDao()
        allPatients = patientDao?.getAllPatients()
    }

    //operations on a single patient
    suspend fun insertPatient(patientEntity: PatientEntity) = db?.patientDao()?.insertPatient(patientEntity)
    suspend fun getPatientById(id: Int) = db?.patientDao()?.getPatientById(id)
    suspend fun updatePatient(patientEntity: PatientEntity) = db?.patientDao()?.updatePatient(patientEntity)
    suspend fun deletePatientById(id: Int) = db?.patientDao()?.deletePatientById(id)
    suspend fun deletePatient(patient: PatientEntity) = db?.patientDao()?.deletePatient(patient)


    //operations on all patients
    suspend fun insertAll(patients: List<PatientEntity>) = db?.patientDao()?.insertAll(patients)
    suspend fun getAllPatients(): LiveData<List<PatientEntity>>? = db?.patientDao()?.getAllPatients()
    suspend fun deleteAllPatients() = db?.patientDao()?.deleteAllPatients()
    suspend fun deletePatients(selectedPatients: List<PatientEntity>) = db?.patientDao()?.deletePatients(selectedPatients)
}