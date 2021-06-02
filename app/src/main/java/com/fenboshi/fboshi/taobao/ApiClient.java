package com.fenboshi.fboshi.taobao;


import com.fenboshi.fboshi.util.HttpUtil;
import com.fenboshi.fboshi.util.SignMD5Util;

import java.net.URISyntaxException;
import java.util.TreeMap;

/**
 * @projectName:dtk-items-openapi
 * @createTime: 2019年11月28日14:13:21
 * @description: APP_SECRET：cd7ddf200ec9e949ac32b232fe6e8a81  APP_KEY：60a76b0562d6a
 */
public class ApiClient {

    public static String sendReqNew(String url, String secret, TreeMap<String, String> paraMap){
        if(null == url || "".equals(url)){
            return "请求地址不能为空";
        }
        if(null == secret || "".equals(secret)){
            return "secret不能为空";
        }
        if(null == paraMap || paraMap.size() < 1){
            return "参数不能为空";
        }

        String timer = String.valueOf(System.currentTimeMillis());
        paraMap.put("timer", timer);
        paraMap.put("nonce", "110505");
        paraMap.put("signRan", SignMD5Util.getSignStrNew(paraMap, secret));
        String data = "";
        try {
            data = HttpUtil.httpGetRequest(url, paraMap);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static String sendReq(String url, String secret, TreeMap<String, String> paraMap){
        if(null == url || "".equals(url)){
            return "请求地址不能为空";
        }
        if(null == secret || "".equals(secret)){
            return "secret不能为空";
        }
        if(null == paraMap || paraMap.size() < 1){
            return "参数不能为空";
        }

        paraMap.put("sign", SignMD5Util.getSignStr(paraMap, secret));
        String data = "";
        try {
            data = HttpUtil.httpGetRequest(url, paraMap);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String[] args) {
        String url = "https://openapi.dataoke.com/api/goods/nine/op-goods-list";
        String appKey = "5f115e3f5ec30";
        String appSecret = "d4cd646cf905e27b13c1519390233c36";
        TreeMap<String, String> paraMap = new TreeMap<>();
        paraMap.put("version", "v2.0.0");
        paraMap.put("appKey", appKey);
        paraMap.put("pageId", "1");
        paraMap.put("pageSize", "20");
//        paraMap.put("keyWords", "男装");
        paraMap.put("nineCid", "1");
        String data = ApiClient.sendReq(url, appSecret, paraMap);
        String sign=SignMD5Util.getSignStr(paraMap, appSecret);
        System.out.println(sign);
    }

}
