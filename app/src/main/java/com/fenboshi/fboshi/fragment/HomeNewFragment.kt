package com.fenboshi.fboshi.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.base.BaseFragment
import kotlinx.android.synthetic.main.home_new_fragment.*


//LifecycleActivity
class  HomeNewFragment:BaseFragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.home_new_fragment,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //如果使用butterknift buind过后直接使用id属性即可
        initView()
        initData()
    }



    @OnClick(R.id.user_name)
   open fun test(){
        Log.d("addObserver","test")
    }

    /**
     * 初始化view
     */
    private fun initView() {
        user_id.text="id123456"
        user_name.text="吴帅军"
    }

    /**
     * 初始化数据
     */
    private fun initData() {

    }




}


