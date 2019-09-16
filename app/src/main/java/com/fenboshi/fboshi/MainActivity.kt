package com.fenboshi.fboshi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.fenboshi.fboshi.bean.UserBean
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
        var userBean= ViewModelProviders.of(this).get<UserBean>()
//        lifecycle.addObserver(GenericLifecycleObserver{ lifecycleOwner: LifecycleOwner, event: Lifecycle.Event ->
//            Log.d("addObserver","event"+event)
//        })


    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
