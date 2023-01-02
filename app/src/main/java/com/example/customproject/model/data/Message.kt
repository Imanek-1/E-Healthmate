package com.example.customproject.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Message(val message: String, val id: String , val timing: String) : Parcelable {
}