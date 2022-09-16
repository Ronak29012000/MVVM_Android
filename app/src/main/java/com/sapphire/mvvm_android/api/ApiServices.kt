package com.sapphire.mvvm_android.api

import com.sapphire.mvvm_android.Constant
import com.sapphire.mvvm_android.models.HoroscopeResponseModel
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServices {

    @POST(ApiConstant.HOROSCOPE)
    fun getHoroscope(
        @Query(Constant.DAY) day: String,
        @Query(Constant.SIGN) sign: String,
    ) : Observable<HoroscopeResponseModel>
}