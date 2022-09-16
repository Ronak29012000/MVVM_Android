package com.sapphire.mvvm_android.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sapphire.mvvm_android.api.ApiConstant
import com.sapphire.mvvm_android.api.ApiProvider
import com.sapphire.mvvm_android.models.HoroscopeResponseModel
import com.sapphire.mvvm_android.models.MessageModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = getApplication<Application>()
    private val mProgress: MutableLiveData<Boolean> = MutableLiveData()
    private val mHandleError: MutableLiveData<MessageModel> = MutableLiveData()
    private val mHoroscopeResponseModel: MutableLiveData<HoroscopeResponseModel> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun observeHoroscope(): LiveData<HoroscopeResponseModel> {
        return mHoroscopeResponseModel
    }


    fun getHoroscope(day: String, sign: String) {
        compositeDisposable.add(
            ApiProvider.callApi(mContext, ApiConstant.BASE_URL_CONSTANT, 0).getHoroscope(day, sign)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    println(it)
                }, {
                    println(it)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }
}