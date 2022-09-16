package com.sapphire.mvvm_android.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MessageModel(

    val message: String

) : Parcelable