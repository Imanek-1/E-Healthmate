package com.example.customproject.model.databaseIntent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.customproject.model.data.Timetable
import com.example.customproject.model.database.timeDatabase
import com.example.customproject.model.database.timetableDao
import java.util.*

private const val DATABASE_NAME = "time_database"
class timetableRepository(private val timetabledao: timetableDao)  {
    fun getTimetable():LiveData<List<Timetable>> = timetabledao.getAvailableTime()

    fun addTime(timetable: Timetable){
        timetabledao.addTimetable(timetable)
    }

    fun addTimeList (listTime : List<Timetable>){
        timetabledao.addTimetableList(listTime)
    }

    fun getTime(day: String, atime: String):LiveData<Timetable> =  timetabledao.getTime(day, atime)

    fun updateTime(timetable: Timetable){
        timetabledao.updateTime(timetable)
    }
}