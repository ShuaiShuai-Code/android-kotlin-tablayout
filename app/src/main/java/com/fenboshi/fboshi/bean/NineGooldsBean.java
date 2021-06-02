package com.fenboshi.fboshi.bean;


import java.util.List;

public class NineGooldsBean   {
     private List<NineGooldsBean> list;
     private String id;
     private String skuId;
     private String goodsId;
     private String title;//淘宝标题
     private String dtitle;//短标题
     private String originalPrice;//商品原价
     private String actualPrice;//券后价
     private String shopType;//店铺类型，1-天猫，0-淘宝
     private String goldSellers;
     private String monthSales;//30天销量
     private String twoHoursSales;//2小时天销量
     private String dailySales;//当天销量
     private String commissionType;//佣金类型，0-通用，1-定向，2-高佣，3-营销计划
     private String desc;//推广文案
     private String couponReceiveNum;//领券量
     private String couponLink;//优惠券链接
     private String couponEndTime;//优惠券结束时间
     private String couponStartTime;//优惠券开始时间
     private String couponPrice;//优惠券金额
     private String couponConditions;//优惠券使用条件
     private String activityType;//活动类型，1-无活动，2-淘抢购，3-聚划算
     private String createTime;//商品上架时间
     private String mainPic;//商品主图链接
     private String marketingMainPic;//marketingMainPic
     private String video;//商品视频
     private String commissionRate;//佣金比例
     private String couponTotalNum;//券总量
     private String itemLink;//商品淘宝链接
     private String freeshipRemoteDistrict;//偏远地区包邮，0.不包邮，1.包邮
     private String estimateAmount;//预估淘礼金
     private String couponAmount;//优惠金额

     public String getSkuId() {
          return skuId;
     }

     public void setSkuId(String skuId) {
          this.skuId = skuId;
     }

     public String getCouponAmount() {
          return couponAmount;
     }

     public void setCouponAmount(String couponAmount) {
          this.couponAmount = couponAmount;
     }

     public List<NineGooldsBean> getList() {
          return list;
     }

     public void setList(List<NineGooldsBean> list) {
          this.list = list;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getGoodsId() {
          return goodsId;
     }

     public void setGoodsId(String goodsId) {
          this.goodsId = goodsId;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getDtitle() {
          return dtitle;
     }

     public void setDtitle(String dtitle) {
          this.dtitle = dtitle;
     }

     public String getOriginalPrice() {
          return originalPrice;
     }

     public void setOriginalPrice(String originalPrice) {
          this.originalPrice = originalPrice;
     }

     public String getActualPrice() {
          return actualPrice;
     }

     public void setActualPrice(String actualPrice) {
          this.actualPrice = actualPrice;
     }

     public String getShopType() {
          return shopType;
     }

     public void setShopType(String shopType) {
          this.shopType = shopType;
     }

     public String getGoldSellers() {
          return goldSellers;
     }

     public void setGoldSellers(String goldSellers) {
          this.goldSellers = goldSellers;
     }

     public String getMonthSales() {
          return monthSales;
     }

     public void setMonthSales(String monthSales) {
          this.monthSales = monthSales;
     }

     public String getTwoHoursSales() {
          return twoHoursSales;
     }

     public void setTwoHoursSales(String twoHoursSales) {
          this.twoHoursSales = twoHoursSales;
     }

     public String getDailySales() {
          return dailySales;
     }

     public void setDailySales(String dailySales) {
          this.dailySales = dailySales;
     }

     public String getCommissionType() {
          return commissionType;
     }

     public void setCommissionType(String commissionType) {
          this.commissionType = commissionType;
     }

     public String getDesc() {
          return desc;
     }

     public void setDesc(String desc) {
          this.desc = desc;
     }

     public String getCouponReceiveNum() {
          return couponReceiveNum;
     }

     public void setCouponReceiveNum(String couponReceiveNum) {
          this.couponReceiveNum = couponReceiveNum;
     }

     public String getCouponLink() {
          return couponLink;
     }

     public void setCouponLink(String couponLink) {
          this.couponLink = couponLink;
     }

     public String getCouponEndTime() {
          return couponEndTime;
     }

     public void setCouponEndTime(String couponEndTime) {
          this.couponEndTime = couponEndTime;
     }

     public String getCouponStartTime() {
          return couponStartTime;
     }

     public void setCouponStartTime(String couponStartTime) {
          this.couponStartTime = couponStartTime;
     }

     public String getCouponPrice() {
          return couponPrice;
     }

     public void setCouponPrice(String couponPrice) {
          this.couponPrice = couponPrice;
     }

     public String getCouponConditions() {
          return couponConditions;
     }

     public void setCouponConditions(String couponConditions) {
          this.couponConditions = couponConditions;
     }

     public String getActivityType() {
          return activityType;
     }

     public void setActivityType(String activityType) {
          this.activityType = activityType;
     }

     public String getCreateTime() {
          return createTime;
     }

     public void setCreateTime(String createTime) {
          this.createTime = createTime;
     }

     public String getMainPic() {
          return mainPic;
     }

     public void setMainPic(String mainPic) {
          this.mainPic = mainPic;
     }

     public String getMarketingMainPic() {
          return marketingMainPic;
     }

     public void setMarketingMainPic(String marketingMainPic) {
          this.marketingMainPic = marketingMainPic;
     }

     public String getVideo() {
          return video;
     }

     public void setVideo(String video) {
          this.video = video;
     }

     public String getCommissionRate() {
          return commissionRate;
     }

     public void setCommissionRate(String commissionRate) {
          this.commissionRate = commissionRate;
     }

     public String getCouponTotalNum() {
          return couponTotalNum;
     }

     public void setCouponTotalNum(String couponTotalNum) {
          this.couponTotalNum = couponTotalNum;
     }

     public String getItemLink() {
          return itemLink;
     }

     public void setItemLink(String itemLink) {
          this.itemLink = itemLink;
     }

     public String getFreeshipRemoteDistrict() {
          return freeshipRemoteDistrict;
     }

     public void setFreeshipRemoteDistrict(String freeshipRemoteDistrict) {
          this.freeshipRemoteDistrict = freeshipRemoteDistrict;
     }

     public String getEstimateAmount() {
          return estimateAmount;
     }

     public void setEstimateAmount(String estimateAmount) {
          this.estimateAmount = estimateAmount;
     }
}