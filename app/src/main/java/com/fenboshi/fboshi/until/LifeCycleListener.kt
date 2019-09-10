package com.fenboshi.fboshi.until

import android.content.Context
import android.util.Log
import androidx.lifecycle.*

/**
 * @author 1140965679@qq.com
 * 生命周期管理工具
 */
class LifeCycleListener(
    context: Context?, lifecycle:Lifecycle,
    callback: Callback?
) :LifecycleObserver{

    var  enabled :Boolean=false
    var  context:Context= context!!
    var  lifecycle:Lifecycle=lifecycle
    var  callback: Callback? =callback


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create(){
        callback?.refresh("ON_CREATE")
        Log.d("addObserver","ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
            callback?.refresh("ON_START")
        Log.d("addObserver","ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume(){
        callback?.refresh("ON_RESUME")
        Log.d("addObserver","ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause(){
        callback?.refresh("ON_PAUSE")
        Log.d("addObserver","ON_PAUSE")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        callback?.refresh("ON_STOP")
        Log.d("addObserver","ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destory() {
        callback?.refresh("ON_DESTROY")
        Log.d("addObserver","ON_DESTROY")
    }


}


