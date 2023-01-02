package com.example.customproject.utils

import com.example.customproject.utils.Constants.ADD_APPOINTMENT
import com.example.customproject.utils.Constants.CANCEL_APPOINTMENT
import com.example.customproject.utils.Constants.UPDATE_APPOINTMENT
import com.example.customproject.utils.Constants.VIEW_APPOINTMENT
import com.example.customproject.utils.Constants.VIEW_TIMETABLE
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponse {
    fun basicResponses(_msg: String): Pair<String, Int> {
        val msg = _msg.toLowerCase()
        val rand = (0..2).random()
        return when {
            //Hello
            msg.contains("hello") || msg.contains("hi") || msg.contains("hey") -> {
                when (rand) {
                    0 -> "Hey nice to meet you, How can I help you today?" to 0
                    1 -> "Hello there, how can I help you today?" to 0
                    2 -> "Hi there, how can I help you today?" to 0
                    else -> "Error" to 0
                }
            }

            msg.contains("view complete") -> {
                "Is there anything else that I can help you with?" to 0
            }

            msg.contains("update complete") -> {
                "You have successfully updated the appointment. Is there anything else that I can help you with?" to 0
            }

            msg.contains("delete complete") -> {
                "You have successfully deleted the appointment. Is there anything else that I can help you with?" to 0
            }

            msg.contains("update incomplete") -> {
                "The process has been cancelled. Is there anything else that I can help you with?" to 0
            }

            msg.contains("add complete") -> {
                "You have successfully added the appointment. Is there anything else that I can help you with?" to 0
            }

            msg.contains("verify incomplete") -> {
                "The verify process is unsuccessful. Is there anything else that I can help you with?" to 0
            }

            msg.contains("add incomplete") -> {
                "The adding process has been cancelled. Is there anythings else that I can help you with?" to 0
            }
            //What time is it?
            msg.contains("time") && msg.contains("?")-> {
                val timer = Timestamp(System.currentTimeMillis())
                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = dateFormat.format(Date(timer.time))
                date.toString() to 0
            }
            //add appointment
            msg.contains("add") || msg.contains("create") || msg.contains("book") && msg.contains("appointment") -> {
                ADD_APPOINTMENT to 0
            }

            // cancel appointment
            msg.contains("cancel") || msg.contains("remove") || msg.contains("delete") && msg.contains(
                "appointment"
            ) -> {
                CANCEL_APPOINTMENT to 0
            }

            // view appointment
            msg.contains("view") || msg.contains("see") && msg.contains("appointment") -> {
                VIEW_APPOINTMENT to 0
            }

            // view appointment
            msg.contains("check") && msg.contains("available time") -> {
                VIEW_TIMETABLE to 0
            }

            msg.contains("update appointment") -> {
                UPDATE_APPOINTMENT to 0
            }

            msg.contains("diagnostic") -> {
                "Give me the symptoms" to 0
            }

            (msg.contains("Rapid heartbeat".toLowerCase(Locale.ROOT)) || msg.contains(
                "fast heartbeat".toLowerCase(
                    Locale.ROOT
                )
            ) || msg.contains("Shortness of breath".toLowerCase(Locale.ROOT)) ||
                    msg.contains("Pale skin".toLowerCase(Locale.ROOT))) -> {
                "These symptoms are related to Anemia" to 1
            }
            msg.contains("Runny nose".toLowerCase(Locale.ROOT)) || msg.contains(
                "Sore throat".toLowerCase(
                    Locale.ROOT
                )
            ) || msg.contains("Fever".toLowerCase(Locale.ROOT)) ||
                    msg.contains("Headache".toLowerCase(Locale.ROOT)) -> {

                "These symptoms are related to Cold and Flu" to 1

            }

            msg.contains("Frequent urination".toLowerCase(Locale.ROOT)) || msg.contains(
                "Excessive thirst".toLowerCase(
                    Locale.ROOT
                )
            ) || msg.contains("Hunger".toLowerCase(Locale.ROOT)) || msg.contains(
                "Blurred vision".toLowerCase(Locale.ROOT)
            ) || msg.contains("Dry skin".toLowerCase(Locale.ROOT)) -> {
                "These symptoms are related to Diabetes" to 1
            }

            else -> {
                when (rand) {
                    0 -> "I don't understand. Can you please try again..." to 0
                    1 -> "Try asking me something different" to 0
                    2 -> "Sorry I don't know what you means. Please ask me another way" to 0
                    else -> "Error" to 0
                }
            }
        }

    }
}