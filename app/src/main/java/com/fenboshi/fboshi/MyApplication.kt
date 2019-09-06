package com.fenboshi.fboshi

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object{
        private  var instance: MyApplication? = null
        fun getApplication(): Context? {
            return instance?.getApplicationContext()
        }
        fun getInstance(): MyApplication? {
            return this!!.instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }



}