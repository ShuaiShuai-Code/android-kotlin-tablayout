package com.fenboshi.fboshi.util;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.baichuan.trade.biz.applink.adapter.AlibcFailModeType;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

import java.util.HashMap;
import java.util.Map;

public class ToTaobaoUtils {
    public static void toTaoBao(Activity activity, String shopId, String pid) {

        // 页面实例557329586365
        AlibcBasePage page = new AlibcDetailPage(shopId);
        //展示参数配置
        AlibcShowParams showParams = new AlibcShowParams();
        showParams.setOpenType(OpenType.Native);
        showParams.setClientType("taobao");
        showParams.setBackUrl("scheme：\"alisdk://\"");
        showParams.setNativeOpenFailedMode(AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD);

// showParam各参数介绍
//        1、OpenType（页面打开方式）： 枚举值（Auto和Native），Native表示唤端，Auto表示不做设置
//        2、clientType表示唤端类型：taobao---唤起淘宝客户端；tmall---唤起天猫客户端
//        3、BACK_URL（小把手）：唤端返回的scheme
//        (如果不传默认将不展示小把手；如果想展示小把手，可以自己传入自定义的scheme，
//        或者传入百川提供的默认scheme："alisdk://")
//        4、AlibcFailModeType（唤端失败模式）： 枚举值如下
//        AlibcNativeFailModeNONE：不做处理；
//        AlibcNativeFailModeJumpBROWER：跳转浏览器；
//        AlibcNativeFailModeJumpDOWNLOAD：跳转下载页；
//        AlibcNativeFailModeJumpH5：应用内webview打开）
//        （注：AlibcNativeFailModeJumpBROWER不推荐使用）
        //mm_1195140093_1883900457_110634750106
        AlibcTaokeParams taokeParams = new AlibcTaokeParams("", "", "");
        taokeParams.setPid(pid);
        String adpid = pid.substring(pid.lastIndexOf("_") + 1, pid.length());
        taokeParams.setAdzoneid(adpid);
        //adzoneid是需要taokeAppkey参数才可以转链成功&店铺页面需要卖家id（sellerId），具体设置方式如下：
        taokeParams.extraParams = new HashMap<>();
        taokeParams.extraParams.put("taokeAppkey", "30462715");
//        taokeParams.extraParams.put("sellerId", "xxxxx");

        //自定义参数
        Map<String, String> trackParams = new HashMap<>();


        AlibcTrade.openByBizCode(activity, page, null, new WebViewClient(),
                new WebChromeClient(), "detail", showParams, taokeParams,
                trackParams, new AlibcTradeCallback() {
                    @Override
                    public void onTradeSuccess(AlibcTradeResult tradeResult) {
                        // 交易成功回调（其他情形不回调）
                        AlibcLogger.i("AlibcTrade", "open detail page success");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        // 失败回调信息
                        AlibcLogger.e("AlibcTrade", "code=" + code + ", msg=" + msg);
                        ToastUtil.showToast("购买此商品需下载淘宝APP");
                    }
                });


//        AlibcShowParams showParams = new AlibcShowParams();
//        showParams.setOpenType(OpenType.Native);
//        showParams.setClientType("taobao");
//        showParams.setBackUrl("scheme：\"alisdk://\"");
////                showParams.setNativeOpenFailedMode(AlibcFailModeType.AlibcNativeFailModeJumpDOWNLOAD);
//
//        AlibcTaokeParams taokeParams = new AlibcTaokeParams("", "", "");
//        taokeParams.setPid(pid);
//
//        Map<String, String> trackParams = new HashMap<>();
//
//
//        AlibcBasePage shopPage = new AlibcShopPage(shopId);
//
//        AlibcTrade.openByBizCode(activity, shopPage, null, new WebViewClient(), new WebChromeClient(),
//                "detail", showParams, taokeParams, trackParams, new AlibcTradeCallback() {
//                    @Override
//                    public void onTradeSuccess(AlibcTradeResult tradeResult) {
//                        // 交易成功回调（其他情形不回调）
//                        AlibcLogger.i("MainActivity", "open detail page success");
//                    }
//
//                    @Override
//                    public void onFailure(int code, String msg) {
//                        AlibcLogger.e("MainActivity", "code=" + code + ", msg=" + msg);
//                        if (code == -1) {
//                            Toast.makeText(activity, "唤端失败，失败模式为none", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
    }
}
