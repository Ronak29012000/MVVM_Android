package com.sapphire.mvvm_android.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class Pref {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun setValue(context: Context?, key: String?, value: Boolean) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context!!)
        editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
        editor.commit()
    }

    fun getValue(context: Context?, key: String?, defaultValue: Boolean): Boolean {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context!!)
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun clear(context: Context?) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context!!)
        editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
        editor.commit()
    }
}