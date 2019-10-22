package com.fenboshi.fboshi.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.leancloud.AVObject
import com.alibaba.fastjson.JSONObject
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.bean.ArticelBean

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
    }




}
