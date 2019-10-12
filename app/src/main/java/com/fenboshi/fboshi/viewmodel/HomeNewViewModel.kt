package com.fenboshi.fboshi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fenboshi.fboshi.bean.ArticelBean

class HomeNewViewModel :ViewModel(){
     // lateinit var userRepository: ArticelRepository
   // lateinit var articelBeanList: LiveData<List<ArticelBean>>
    private  var articelBean: MutableLiveData<List<ArticelBean>>? = null
    fun getListData() :LiveData<List<ArticelBean>>{
//       if(this.articelBeanList!=null){
//           return articelBeanList
//       }
        var userRepository=ArticelRepository()
        return  userRepository!!.getArticel()
    }

    fun setArtice(articelBeanList: List<ArticelBean>){
        articelBean?.value =articelBeanList
    }

//    fun HomeNewViewModel(userRepository: ArticelRepository){
//        this.userRepository =userRepository
//    }
}