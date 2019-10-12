package com.fenboshi.fboshi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import cn.leancloud.AVObject
import cn.leancloud.AVQuery
import com.fenboshi.fboshi.bean.UserBean
import com.fenboshi.fboshi.viewmodel.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import io.reactivex.Observer as Observer

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        actionBar?.setDisplayHomeAsUpEnabled(false)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bnv_menu.setupWithNavController(navController)
        var userViewModel= ViewModelProviders.of(this).get<UserViewModel>()


        val nameObserver = object : androidx.lifecycle.Observer<UserBean> {
            override fun onChanged(t: UserBean?) {

                Log.d("UserBean","event"+ (t?.mobile ?:"123@11.com"))
                Log.d("UserBean","event"+ (t?.nickName ?:"幽你一默"))
            }


        }
        userViewModel.getUser().observe(this,nameObserver)
        //获取数据
        val query = AVQuery<AVObject>("_User")
        query.getInBackground("5d88755f7b968a008a346254")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<AVObject> {
                override fun onSubscribe(disposable: Disposable) {
                }
                override fun onNext(todo: AVObject) {
                    // todo 就是 objectId 为 582570f38ac247004f39c24b 的 Todo 实例
                    val name = todo.getString("username")
                    val email = todo.getString("email")
                    // int priority    = todo.getInt("priority");
                   var userBean=UserBean()
                    userBean.nickName=name
                    userBean.mobile=email
                    userViewModel.setUser(userBean)
                }

                override fun onError(throwable: Throwable) {}
                override fun onComplete() {

                }
            })

    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }


}
