package com.sapphire.mvvm_android.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HoroscopeResponseModel(

	@field:SerializedName("date_range")
	val dateRange: String? = null,

	@field:SerializedName("current_date")
	val currentDate: String? = null,

	@field:SerializedName("mood")
	val mood: String? = null,

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("lucky_time")
	val luckyTime: String? = null,

	@field:SerializedName("compatibility")
	val compatibility: String? = null,

	@field:SerializedName("lucky_number")
	val luckyNumber: String? = null
) : Parcelable
