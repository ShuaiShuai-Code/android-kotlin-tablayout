package com.fenboshi.fboshi.bean;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


//todo 没有用kotlin写bean，是因为数据库映射不出UserBeanDao
@Entity
public class UserBean  implements Serializable {
     private String accessToken;//Token
     private String deviceId;//设备id
     private String id = "1140965679";//用户id
     private String mobile;
     private String nickName ="幽你一默";
     private String avatarUrl;
     private static final long serialVersionUID = -4211449776975163975L;

     public UserBean() {
          super();
     }



     @Generated(hash = 409608755)
    public UserBean(String accessToken, String deviceId, String id, String mobile,
            String nickName, String avatarUrl, int sex, String birthday) {
        this.accessToken = accessToken;
        this.deviceId = deviceId;
        this.id = id;
        this.mobile = mobile;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
        this.sex = sex;
        this.birthday = birthday;


    }



    @Override
     public int hashCode() {
          return super.hashCode();
     }

     @Override
     public boolean equals(@Nullable Object obj) {
          return super.equals(obj);
     }

     @NonNull
     @Override
     protected Object clone() throws CloneNotSupportedException {
          return super.clone();
     }

     @NonNull
     @Override
     public String toString() {
          return super.toString();
     }

     @Override
     protected void finalize() throws Throwable {
          super.finalize();
     }

     public String getAccessToken() {
         return this.accessToken;
     }

     public void setAccessToken(String accessToken) {
         this.accessToken = accessToken;
     }

     public String getDeviceId() {
         return this.deviceId;
     }

     public void setDeviceId(String deviceId) {
         this.deviceId = deviceId;
     }

     public String getId() {
         return this.id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getMobile() {
         return this.mobile;
     }

     public void setMobile(String mobile) {
         this.mobile = mobile;
     }

     public String getNickName() {
         return this.nickName;
     }

     public void setNickName(String nickName) {
         this.nickName = nickName;
     }

     public String getAvatarUrl() {
         return this.avatarUrl;
     }

     public void setAvatarUrl(String avatarUrl) {
         this.avatarUrl = avatarUrl;
     }

     public int getSex() {
         return this.sex;
     }

     public void setSex(int sex) {
         this.sex = sex;
     }

     public String getBirthday() {
         return this.birthday;
     }

     public void setBirthday(String birthday) {
         this.birthday = birthday;
     }

     private int sex;
     private String birthday;



}