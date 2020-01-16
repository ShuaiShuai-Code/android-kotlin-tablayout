package com.fenboshi.fboshi.adpater

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cn.leancloud.AVObject
import com.airbnb.lottie.LottieAnimationView
import com.alibaba.fastjson.JSONObject
import com.bumptech.glide.Glide
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.activity.ContentDetailActivity
import com.fenboshi.fboshi.bean.ArticelBean
import de.hdodenhof.circleimageview.CircleImageView

class HomeRecyAdpater(private var mContext:Context,private var data:List<AVObject>) : RecyclerView.Adapter<HomeRecyAdpater.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        if(null==data)
            return
        var jsonObject: JSONObject? =JSONObject.parseObject(data[position].toJSONString())
        try {
            var jsonObjectstr: JSONObject? =jsonObject?.getJSONObject("serverData")
            var articelBean:ArticelBean=JSONObject.parseObject(jsonObjectstr.toString(),ArticelBean::class.java)
            holder.auto.text=articelBean.auto
            holder.title.text=articelBean.title
            holder.tv_content.text=articelBean.content
            holder.animation_view.setOnClickListener{
                Toast.makeText(mContext,"点赞",Toast.LENGTH_LONG).show()
                holder.animation_view.useHardwareAcceleration()
                holder.animation_view.setSpeed(1F)
                holder.animation_view.playAnimation()
            }
            Glide.with(mContext).load(articelBean.headImage).into(holder.profile_image)

            holder.View.setOnClickListener{
                var intent = Intent(mContext, ContentDetailActivity::class.java)
                intent.putExtra("articelBean",articelBean)
                mContext.startActivity(intent)
                }
        }catch (e:Exception){
            println(e)
        }
    }

    override fun getItemCount(): Int= data.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var View=LayoutInflater.from(mContext).inflate(R.layout.home_new_fragment_item,parent,false)
        return  MyHolder(View)
    }
    class  MyHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var title:TextView =itemView.findViewById(R.id.title_template)
        var auto:TextView =itemView.findViewById(R.id.auto)
        var tv_content:TextView =itemView.findViewById(R.id.tv_content)
        var animation_view:LottieAnimationView =itemView.findViewById(R.id.animation_view)
        var profile_image:CircleImageView =itemView.findViewById(R.id.profile_image)
        var View =itemView
    }




}


