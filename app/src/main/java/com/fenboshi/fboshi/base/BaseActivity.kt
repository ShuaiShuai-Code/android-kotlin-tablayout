package com.fenboshi.fboshi.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.fenboshi.fboshi.until.LifeCycleListener

/**
 * baseactivity 基础代码可以写到这里
 */
class BaseActivity :AppCompatActivity(){
    lateinit var myLocationListener: LifeCycleListener
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initLocationListener()
    }

    private fun initLocationListener() {
        myLocationListener = LifeCycleListener(this, lifecycle,null)
        lifecycle.addObserver(myLocationListener)

    }

}
