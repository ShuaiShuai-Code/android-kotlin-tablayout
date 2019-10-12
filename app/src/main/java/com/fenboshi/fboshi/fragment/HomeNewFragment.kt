package com.fenboshi.fboshi.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import cn.leancloud.AVObject
import cn.leancloud.AVQuery
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.base.BaseFragment
import com.fenboshi.fboshi.bean.ArticelBean
import com.fenboshi.fboshi.bean.UserBean
import com.fenboshi.fboshi.component.DaggerUserBeanComPonent
import com.fenboshi.fboshi.databinding.HomeNewFragmentBinding
import com.fenboshi.fboshi.viewmodel.HomeNewViewModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


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
        var userViewModel= ViewModelProviders.of(this).get<HomeNewViewModel>()
        var nameObserver =object:androidx.lifecycle.Observer<List<ArticelBean>>{
            override fun onChanged(articelBean: List<ArticelBean>?) {
               updataUI(articelBean!!)
            }
        }
        userViewModel.getListData().observe(this,nameObserver)
        homeNewFragmentBinding.userBean=userBean.apply {
            this.id=id
            this.nickName=nickName
        }
    }

        fun updataUI(listArtice: List<ArticelBean>){
            var articelBeanList:List<ArticelBean>

            for(artice in listArtice){
                Log.i("ArticelBean", artice.auto)
            }
        }


}












