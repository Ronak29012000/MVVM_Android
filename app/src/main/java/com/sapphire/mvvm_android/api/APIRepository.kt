package com.sapphire.mvvm_android.api

import com.sapphire.mvvm_android.models.HoroscopeResponseModel
import io.reactivex.Observable

class APIRepository(private val apiServices: ApiServices) {
    fun getHoroscope(day: String, sign: String): Observable<HoroscopeResponseModel> {
        return apiServices.getHoroscope(day, sign)
    }
}