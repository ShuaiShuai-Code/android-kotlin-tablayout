package com.fenboshi.fboshi.network.Gson;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fenboshi.fboshi.util.StringUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;


    public GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        //先将返回的json数据解析到Response中，如果code==200，则解析到我们的实体基类中，否则抛异常
//        Log.d("GsonResponseBodyConverter" + type.toString());
//        String data= StringUtil.conventFromGzip(response);
        JSONObject jsonObject = JSON.parseObject(response);
//        Response httpResult = gson.fromJson(response, Response.class);
        /**
         * Gson
         */
        if (jsonObject.getInteger("code") == 0 && !jsonObject.get("data").toString().isEmpty()) {
            //200的时候就直接解析，不可能出现解析异常。因为我们实体基类中传入的泛型，就是数据成功时候的格式
            return JSONObject.parseObject(response, type);
        } else if (jsonObject.getInteger("code") == 0) {
//            jsonObject.remove("data");
            jsonObject.put("data", type);
            return JSONObject.parseObject(jsonObject.toJSONString(), type);
        } else {
            // ToastUtil.showToast(httpResult.message());
            jsonObject.remove("data");
            return JSONObject.parseObject(jsonObject.toJSONString(), type);
        }

        /**
         * fast json
         */
//        if (httpResult.code() == 200 && !jsonObject.get("data").toString().isEmpty()) {
//            //200的时候就直接解析，不可能出现解析异常。因为我们实体基类中传入的泛型，就是数据成功时候的格式
//            return JSONObject.parseObject(jsonObject.toString(), type);
//        } else if (httpResult.code() == 200) {
//            jsonObject.remove("data");
//            jsonObject.put("data", new NoDataResponse());
//            return JSONObject.parseObject(jsonObject.toString(), type);
//        } else {
//            // ToastUtil.showToast(httpResult.message());
//            jsonObject.remove("data");
//            return JSONObject.parseObject(jsonObject.toString(), type);
//        }

    }
}
