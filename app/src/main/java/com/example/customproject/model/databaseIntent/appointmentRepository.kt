package com.example.customproject.model.databaseIntent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.customproject.model.data.Appointment
import com.example.customproject.model.data.Timetable
import com.example.customproject.model.database.appointmentDao
import com.example.customproject.model.database.appointmentDatabase
import com.example.customproject.model.database.timetableDao
import java.util.*

private const val DATABASE_NAME = "appointment-database"
class appointmentRepository(private val appointmentdao: appointmentDao) {

    fun addAppointment(appointment: Appointment){
        appointmentdao.addAppointment(appointment)
    }

    fun updateAppointment(appointment: Appointment){
        appointmentdao.updateAppointment(appointment)
    }

    fun deleteAppointment(appointment: Appointment){
        appointmentdao.deleteAppointment(appointment)
    }

    fun getAppointment(email: String, phone: String): LiveData<Appointment> =  appointmentdao.getAppointment(email, phone)

    fun getAll():LiveData<List<Appointment>> = appointmentdao.getAllAppointment()
}