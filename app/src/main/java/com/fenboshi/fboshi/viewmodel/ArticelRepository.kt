package com.fenboshi.fboshi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import cn.leancloud.AVObject
import cn.leancloud.AVQuery
import com.alibaba.fastjson.JSONObject
import com.fenboshi.fboshi.bean.ArticelBean
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class ArticelRepository {

    fun   getArticel(): LiveData<List<AVObject>> {
        var mediatorLiveData= MediatorLiveData<List<AVObject>>()
        //获取数据
        val query = AVQuery<AVObject>("Article")
        query.findInBackground()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<AVObject>> {
                override fun onNext(listArtice: List<AVObject>) {
                    Log.d("UserBean","event"+"onNext" )
//                    var articelBean =ArticelBean()
//                    articelBean.auto="作者"
//                    articelBean.content="内容"
//                    articelBean.title="标题"
//                    articelBean.type="1"
                    val articelBeanList = ArrayList<AVObject>()
                    articelBeanList.addAll(listArtice)
                   mediatorLiveData.value=listArtice

                }
                override fun onComplete() {
                    Log.d("UserBean","event"+"onComplete" )
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("UserBean","onSubscribe"+ d)
                }

                override fun onError(e: Throwable) {
                    Log.d("UserBean","onError"+e )
                }


            })
        return  mediatorLiveData
        }



}