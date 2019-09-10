package com.fenboshi.fboshi.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.fenboshi.fboshi.until.LifeCycleListener
/**
 * baseFragment 基础代码可以写到这里
 */
open class BaseFragment :Fragment(){
    lateinit var myLocationListener: LifeCycleListener
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initLocationListener()
    }
     private fun initLocationListener() {
        myLocationListener = LifeCycleListener(context, lifecycle,null)
        lifecycle.addObserver(myLocationListener)

    }

}
