package com.fenboshi.fboshi.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.fenboshi.fboshi.MainActivity
import com.fenboshi.fboshi.R

/**
 * 问专家
 */
class  HomeExpertFragment:Fragment(){
    lateinit var tabLayout: TabLayout
    lateinit var viewPager:ViewPager
    private val liststr = ArrayList<String>(3)
    private val mFragment = ArrayList<Fragment>(3)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.home_expert_fragment,container,false)
        return view
    }


}