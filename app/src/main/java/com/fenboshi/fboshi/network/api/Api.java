package com.fenboshi.fboshi.network.api;

import com.fenboshi.fboshi.network.model.NoDataResponse;
import com.fenboshi.fboshi.network.rx.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    //获取短信验证码
    @POST("user/sendSms.htm")
    @FormUrlEncoded
    Observable<BaseResponse<NoDataResponse>> sendSms(@Field("mobile") String mobile,
                                                     @Field("type") int type,
                                                     @Field("imageCode") String code,
                                                     @Field("uuid") String uuid);

    //注册
//    @POST("user/signup.htm")
//    @FormUrlEncoded
//    Observable<BaseResponse<Kt>> signup(@Field("mobile") String mobile,
//                                              @Field("checkCode") String checkCode,
//                                              @Field("password") String password,
//                                              @Field("deviceId") String deviceId,
//                                              @Field("signUpSource") String signUpSource);

    //登陆
//    @POST("user/login.htm")
//    @FormUrlEncoded
//    Observable<BaseResponse<Kt>> login(@Field("mobile") String mobile,
//                                             @Field("password") String password,
//                                             @Field("loginType") int loginType,
//                                             @Field("checkCode") String checkCode);


//    //重置登录密码
//    @POST("user/resetPassword.htm")
//    @FormUrlEncoded
//    Observable<BaseResponse<NoDataResponse>> resetLoginPwd(@FieldMap Map<String, Object> map);



    /**
     * 查询订单列表
     */
//    @POST("order/orderList.htm")
//    @FormUrlEncoded
//    Observable<BaseResponse<PagingModel<OrderListModel>>> orderList(@Field("pageType") int pageType,
//                                                                    @Field("orderStatus") int orderStatus,

    /**
     * /**
     * 新增住房产品
     */
//    @POST("product/applyRoom.htm")
//    @FormUrlEncoded
//    Observable<BaseResponse<NoDataResponse>> houseProduct(@FieldMap Map<String, Object> map);

    /**
     * 产品列表
     */
//    @POST("product/list.htm")
//    @FormUrlEncoded
//    Observable<BaseResponse<PagingModel<ProductBean>>> productList(@Field("isUp") int isUp,
//                                                                   @Field("pageNum") int pageNum);




}




