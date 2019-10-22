package com.fenboshi.fboshi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.leancloud.AVObject
import com.fenboshi.fboshi.bean.ArticelBean
import com.fenboshi.fboshi.component.DaggerArticelComPonent
import javax.inject.Inject

class HomeNewViewModel :ViewModel(){
    @Inject
    lateinit var userRepository: ArticelRepository

    private  var articelBean: MutableLiveData<List<ArticelBean>>? = null

    fun getListData() :LiveData<List<AVObject>>{
        DaggerArticelComPonent.create().inject(this)
        return  userRepository!!.getArticel()
    }

    fun setArtice(articelBeanList: List<ArticelBean>){
        articelBean?.value =articelBeanList
    }




}