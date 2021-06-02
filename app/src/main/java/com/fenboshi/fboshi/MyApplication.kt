package com.fenboshi.fboshi

import android.app.Application
import android.content.Context
import cn.leancloud.core.AVOSCloud
import cn.leancloud.core.AVOSService
import cn.leancloud.AVObject
import com.alibaba.baichuan.android.trade.AlibcTradeSDK
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback
import com.alibaba.baichuan.trade.common.AlibcTradeCommon
import com.socks.library.KLog


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
        //百川
        AlibcTradeSDK.asyncInit(this, object : AlibcTradeInitCallback {
            override fun onSuccess() {
                KLog.i("WelcomeActivity", "百川初始化成功：openUrl：-------->  ")
                //ToastUtil.showToast("初始化成功");
            }

            override fun onFailure(code: Int, msg: String) {
                KLog.i("WelcomeActivity", "百川初始化失败：openUrl：-------->  ")
                //ToastUtil.showToast("初始化失败");
            }
        })
        AlibcTradeSDK.setSyncForTaoke(true)
        AlibcTradeCommon.turnOnDebug()
    }

}