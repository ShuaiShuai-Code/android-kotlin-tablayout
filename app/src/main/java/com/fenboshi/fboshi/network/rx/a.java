package com.fenboshi.fboshi.network.rx;

import java.util.List;

/**
 * Created by mc on 2018/10/17.
 * yang-wen-wen
 */

public class a {


    /**
     * data : [{"createTime":1529649006000,"id":1,"linkUrl":"https://www.yingkd.com/yingkd/H5/invite.html","name":"邀请好友","picUrl":"http://yingkd-image.oss-cn-hangzhou.aliyuncs.com/yingkd-image/admin/29d8e51a-e643-4f78-969d-ecd0ed0e3f33.png","position":"h5","sort":1,"state":"show","target":"","updateTime":1533727010000},{"createTime":1529653921000,"id":2,"linkUrl":"http://oprsemriy.bkt.clouddn.com/aboutYkd.html","name":"关于盈口袋","picUrl":"http://yingkd-image.oss-cn-hangzhou.aliyuncs.com/yingkd-image/admin/6b169167-2d5e-47e9-8bec-5ee8d83b719b.png","position":"h5","sort":2,"state":"show","target":"","updateTime":1534817632000},{"createTime":1539244866000,"id":10,"linkUrl":"www","picUrl":"http://yingkd-image.oss-cn-hangzhou.aliyuncs.com/yingkd-image/admin/b0d7e904-7400-4f5c-a83d-30a78534a5f3.png","position":"h5","sort":10,"state":"show","updateTime":1539245841000}]
     * retCode : 200
     */

    private String retCode;
    private List<DataBean> data;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : 1529649006000
         * id : 1
         * linkUrl : https://www.yingkd.com/yingkd/H5/invite.html
         * name : 邀请好友
         * picUrl : http://yingkd-image.oss-cn-hangzhou.aliyuncs.com/yingkd-image/admin/29d8e51a-e643-4f78-969d-ecd0ed0e3f33.png
         * position : h5
         * sort : 1
         * state : show
         * target :
         * updateTime : 1533727010000
         */

        private long createTime;
        private int id;
        private String linkUrl;
        private String name;
        private String picUrl;
        private String position;
        private int sort;
        private String state;
        private String target;
        private long updateTime;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
    }
}
