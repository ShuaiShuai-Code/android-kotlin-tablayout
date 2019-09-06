package com.fenboshi.fboshi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.bean.UserBean
import com.fenboshi.fboshi.db.DaoManager

class  ChatFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.chat_fragment,container,false)
        var userBean= UserBean()
        return view
    }
}

