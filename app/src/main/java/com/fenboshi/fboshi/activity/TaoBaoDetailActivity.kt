package com.fenboshi.fboshi.activity

import android.app.Activity
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.network.api.ApiCreator
import com.fenboshi.fboshi.network.exception.ResponeThrowable
import com.fenboshi.fboshi.network.rx.BaseObserver
import com.fenboshi.fboshi.network.rx.RxTransformer
import com.fenboshi.fboshi.util.ToTaobaoUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.content_tao_bao_detail.*

import java.math.BigDecimal

class TaoBaoDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_tao_bao_detail)
        initdata()
        initListener()
    }


    private var outside_url: String = ""
    private var pid: String = ""
    private var cname: String = ""
    private lateinit var money: BigDecimal
    private var title: String = ""
    private lateinit var coupons_money: BigDecimal


    private fun initdata() {
        pid = intent.getStringExtra("pid")
        cname = intent.getStringExtra("cname")
        outside_url = intent.getStringExtra("outside_url")

    }

    private fun initListener() {

        bt_toPay.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    bt_toPay.background =
                        ContextCompat.getDrawable(this, R.drawable.background_orger_pay_5)
                    // 记录点下去的点（起点）
                    return@setOnTouchListener false
                }

            }

            return@setOnTouchListener false
        }
        bt_toPay.setOnClickListener {

            ToTaobaoUtils.toTaoBao(this, outside_url, "mm_55212074_38988192_153818895")
        }
        img_back.setOnClickListener {
            finish()
        }
        rr_back.setOnClickListener {
            finish()
        }
        try {
            var cid = intent.getStringExtra("cid")
            var gid = intent.getStringExtra("gid")


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}
