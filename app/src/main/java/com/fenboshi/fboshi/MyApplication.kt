package com.fenboshi.fboshi

import android.app.Application
import android.content.Context
import cn.leancloud.core.AVOSCloud
import cn.leancloud.core.AVOSService
import cn.leancloud.AVObject



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
        //leancloud 服务初始化
        AVOSCloud.initialize("9hhckR5pqY7J5ubhK2wBXNsF-gzGzoHsz", "fcFBEQ5kuVE7D3N2S5Os1VHe")

    }

}