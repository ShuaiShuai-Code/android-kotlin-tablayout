package com.fenboshi.fboshi.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

import cn.leancloud.AVObject;


//todo 没有用kotlin写bean，是因为数据库映射不出UserBeanDao
@Entity
public class ArticelBean   implements Serializable {
     private String title;
     private String auto;
     private String type;
     private String content;
    private static final long serialVersionUID = -9776975163975L;

    @Generated(hash = 1965417262)
    public ArticelBean(String title, String auto, String type, String content) {
        this.title = title;
        this.auto = auto;
        this.type = type;
        this.content = content;
    }

    @Generated(hash = 692915774)
    public ArticelBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}