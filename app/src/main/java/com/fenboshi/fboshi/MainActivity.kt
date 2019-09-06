package com.fenboshi.fboshi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setDisplayHomeAsUpEnabled(false)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bnv_menu.setupWithNavController(navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }
    /**
     * 一个基于kotlin的demo，主要是两个功能，一个是底部导航，使用了BottomNavigationView，首页一个tablayout+viewpager+fragment，
    一个小型架构，目前没有数据交互，可以自己扩展，后期会迭代mvvm架构的项目
     */

}
