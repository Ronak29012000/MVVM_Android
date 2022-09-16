package com.sapphire.mvvm_android.api

import android.content.Context

object ApiProvider {
    fun callApi(context: Context, urlCode: Int, header: Int): APIRepository {
        return APIRepository(
            ServiceGenerator.createService(
                ApiServices::class.java,
                context,
                urlCode,
                header
            )
        )
    }
}