package com.fenboshi.fboshi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fenboshi.fboshi.bean.UserBean
  class UserViewModel: ViewModel() {

    private var userBeanMutableLiveData: MutableLiveData<UserBean>? = null
    fun getUser(): LiveData<UserBean> {
        if (userBeanMutableLiveData == null) {
            userBeanMutableLiveData = MutableLiveData()
        }
        return userBeanMutableLiveData as MutableLiveData<UserBean>
    }
    fun setUser(user: UserBean) {
        userBeanMutableLiveData?.value =user
    }
}
