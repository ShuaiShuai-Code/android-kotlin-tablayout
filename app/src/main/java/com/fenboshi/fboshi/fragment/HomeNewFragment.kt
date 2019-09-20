package com.fenboshi.fboshi.fragment
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.base.BaseFragment
import com.fenboshi.fboshi.bean.UserBean
import com.fenboshi.fboshi.component.DaggerUserBeanComPonent
import com.fenboshi.fboshi.databinding.HomeNewFragmentBinding
import javax.inject.Inject


//LifecycleActivity
class  HomeNewFragment:BaseFragment(){
private lateinit var homeNewFragmentBinding :HomeNewFragmentBinding

    @Inject
    lateinit var userBean: UserBean

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeNewFragmentBinding =  DataBindingUtil.inflate(
            inflater,
            R.layout.home_new_fragment,
            container,
            false
        )

        return  homeNewFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        DaggerUserBeanComPonent.create().inject(this)
        homeNewFragmentBinding.setLifecycleOwner(viewLifecycleOwner)

        homeNewFragmentBinding.userBean=userBean.apply {
            this.id=id
            this.nickName=nickName
        }
    }






}


