package com.fenboshi.fboshi.network.interceptor;

import android.text.TextUtils;

import com.fenboshi.fboshi.bean.UserBean;
import com.fenboshi.fboshi.db.DaoManager;
import com.fenboshi.fboshi.network.ApiConstant;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class HeaderInterceptor implements Interceptor {

    private String mAccessToken = "";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader(ApiConstant.ACCESS_TOKEN, getAccessToken())
                .addHeader(ApiConstant.DEVICE_TYPE, ApiConstant.ANDROID)
                .build();
        return chain.proceed(request);
    }
        //TODO 需要修改token
    private String getAccessToken() {
        UserBean userEntity = DaoManager.getInstance().getUserBean();
        if (userEntity != null && !TextUtils.isEmpty(userEntity.getAccessToken())) {
            mAccessToken = userEntity.getAccessToken();
        }
        return mAccessToken;
    }
}
