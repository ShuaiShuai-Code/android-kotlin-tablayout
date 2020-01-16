package com.fenboshi.fboshi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.fenboshi.fboshi.R
import com.fenboshi.fboshi.bean.ArticelBean
import com.fenboshi.fboshi.bean.AskCommentUnit
import kotlinx.android.synthetic.main.activity_content_detail.*
import org.json.JSONObject

class ContentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail)
        intData()
        initComment()
    }

    private var jobj: JSONObject? = null
    private fun initComment() {
        var requery =
            "{\"code\":\"200\",\"message\":\"请求成功\",\"replies\":13,\"data\":[{\"message\":\"你好\",\"pid\":2020,\"votenums\":0,\"infoid\":2020,\"elite\":0,\"userid\":148,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191213\\/d7b408eedc88a7768148699641e802bd.jpg\",\"usertype\":9,\"nickname\":\"智蜂麦谱专家宋代表\",\"inputtime\":\"2019-12-13\",\"pic\":\"\",\"isVote\":0,\"image\":[],\"thumb\":[],\"subclass\":{\"count\":0,\"list\":[]}},{\"message\":\"KKK快来咯LOMO了看了就看了看了就看了看了就看了看了就看了出来咯啦啦啦啦KKKJK\",\"pid\":2001,\"votenums\":0,\"infoid\":2001,\"elite\":0,\"userid\":93,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191017\\/ecf85f14d460d776a2b3b01f145d23db.jpg\",\"usertype\":1,\"nickname\":\"蜂友9775\",\"inputtime\":\"2019-12-09\",\"pic\":\"\",\"isVote\":0,\"image\":[],\"thumb\":[],\"subclass\":{\"count\":11,\"list\":[{\"message\":\"粑粑擦擦擦啦啦啦啦啦啦啦啦啦啦啦啦看了就看了啦啦啦啦啦啦啊啦啦啦啦啦看了就看了啊啦啦啦啦啦啦啦啦啦啦\",\"parentUid\":93,\"pid\":2002,\"votenums\":0,\"infoid\":2002,\"elite\":0,\"userid\":147,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/static\\/images\\/normal-person.png\",\"usertype\":1,\"nickname\":\"蜂友9774\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"蜂友9775\"},{\"message\":\"男的女的你康桑密达男的女的你等你男的女的你等你等你男的女的你的男的女的你你到哪想你想你想你等你牛仔你是男的女的你到哪你放假记得记得几点能到南方基金房价腐男腐女解放军军训基地男的女的你？\",\"parentUid\":93,\"pid\":2005,\"votenums\":1,\"infoid\":2005,\"elite\":0,\"userid\":115,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191115\\/fa02f5c3c67e3acde3c487cd7c34ad7e.jpg\",\"usertype\":11,\"nickname\":\"小飞\uD83E\uDD17\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"蜂友9775\"},{\"message\":\"你到哪腐男腐女纯牛奶吃奶粉你发那我你到哪腐男腐女蜂农带你吃那你吃你瞅瞅你你到哪蜂农才能进行江西南昌你从哪见到你才能吃见到你等你。\",\"parentUid\":93,\"pid\":2006,\"votenums\":1,\"infoid\":2006,\"elite\":0,\"userid\":115,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191115\\/fa02f5c3c67e3acde3c487cd7c34ad7e.jpg\",\"usertype\":11,\"nickname\":\"小飞\uD83E\uDD17\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"蜂友9775\"},{\"message\":\"亘古不变步步高腹股沟管股海护航古古怪怪滚滚滚滚滚滚刚刚vvvvv厄尔语句还好还好哈！胡话别v给地方滚滚滚开了学校吗啡…\",\"parentUid\":115,\"pid\":2007,\"votenums\":0,\"infoid\":2007,\"elite\":0,\"userid\":142,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/static\\/images\\/normal-person.png\",\"usertype\":1,\"nickname\":\"用户甲\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"小飞\uD83E\uDD17\"},{\"message\":\"孤孤单单发发发\",\"parentUid\":115,\"pid\":2008,\"votenums\":0,\"infoid\":2008,\"elite\":0,\"userid\":142,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/static\\/images\\/normal-person.png\",\"usertype\":1,\"nickname\":\"用户甲\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"小飞\uD83E\uDD17\"},{\"message\":\"你好好休息\",\"parentUid\":142,\"pid\":2009,\"votenums\":0,\"infoid\":2009,\"elite\":0,\"userid\":142,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/static\\/images\\/normal-person.png\",\"usertype\":1,\"nickname\":\"用户甲\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"用户甲\"},{\"message\":\"倪倪倪哥俩\",\"parentUid\":115,\"pid\":2010,\"votenums\":0,\"infoid\":2010,\"elite\":0,\"userid\":142,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/static\\/images\\/normal-person.png\",\"usertype\":1,\"nickname\":\"用户甲\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"小飞\uD83E\uDD17\"},{\"message\":\"。都没事\",\"parentUid\":115,\"pid\":2019,\"votenums\":0,\"infoid\":2019,\"elite\":0,\"userid\":148,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191213\\/d7b408eedc88a7768148699641e802bd.jpg\",\"usertype\":9,\"nickname\":\"智蜂麦谱专家宋代表\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"小飞\uD83E\uDD17\"},{\"message\":\"很棒棒\",\"parentUid\":148,\"pid\":2030,\"votenums\":0,\"infoid\":2030,\"elite\":0,\"userid\":115,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191115\\/fa02f5c3c67e3acde3c487cd7c34ad7e.jpg\",\"usertype\":11,\"nickname\":\"小飞\uD83E\uDD17\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"智蜂麦谱专家宋代表\"},{\"message\":\"本爸爸坎坎坷坷看\",\"parentUid\":115,\"pid\":2031,\"votenums\":0,\"infoid\":2031,\"elite\":0,\"userid\":115,\"avatar\":\"http:\\/\\/apitest.hibeeok.com\\/uploads\\/avatar\\/20191115\\/fa02f5c3c67e3acde3c487cd7c34ad7e.jpg\",\"usertype\":11,\"nickname\":\"小飞\uD83E\uDD17\",\"inputtime\":\"2019-12-13\",\"isVote\":0,\"parentUserName\":\"小飞\uD83E\uDD17\"}]}}]}\n"
        jobj = JSONObject(requery)
        val jsonObjectCopy = com.alibaba.fastjson.JSONObject.parseObject(jobj.toString())
        val jsonArray =
            com.alibaba.fastjson.JSONObject.parseArray(jsonObjectCopy["data"]!!.toString())
        val list = com.alibaba.fastjson.JSONObject.parseArray(
            jsonArray.toString(),
            AskCommentUnit::class.java
        )
        txt_learn_detail_comment.text=list.size.toString()
    }

    private fun intData() {
        var articelBean: ArticelBean = intent.getSerializableExtra("articelBean") as ArticelBean
        Glide.with(this).load(articelBean.headImage).into(head_img)
        tv_auto.text = articelBean.auto
        tv_cotent.text = articelBean.content
    }
}
