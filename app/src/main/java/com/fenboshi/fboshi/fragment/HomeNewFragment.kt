package com.fenboshi.fboshi.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import cn.leancloud.AVObject
import com.fenboshi.fboshi.MainActivity
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.adpater.HomeRecyAdpater
import com.fenboshi.fboshi.base.BaseFragment
import com.fenboshi.fboshi.bean.UserBean
import com.fenboshi.fboshi.component.DaggerUserBeanComPonent
import com.fenboshi.fboshi.databinding.HomeNewFragmentBinding
import com.fenboshi.fboshi.viewmodel.HomeNewViewModel
import kotlinx.android.synthetic.main.home_new_fragment.*
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

        var homeNewViewModel= ViewModelProviders.of(this).get<HomeNewViewModel>()
        var nameObserver =object:androidx.lifecycle.Observer<List<AVObject>>{
            override fun onChanged(articelBean: List<AVObject>?) {
               updataUI(articelBean!!)
            }
        }
        homeNewViewModel.getListData().observe(this,nameObserver)


    }

        fun updataUI(listArtice: List<AVObject>){
        var homeRecyAdpater=HomeRecyAdpater(activity as MainActivity,listArtice)
            recyclerView.layoutManager=LinearLayoutManager(activity)
            recyclerView.adapter=homeRecyAdpater
        }


}












