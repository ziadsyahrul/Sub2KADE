package com.ziadsyahrul.sub2kade

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.orhanobut.hawk.Hawk

class BaseApp : Application() {

    override fun onCreate(){
        super.onCreate()

        Hawk.init(this).build()
        AndroidNetworking.initialize(this)
        AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
    }
}
