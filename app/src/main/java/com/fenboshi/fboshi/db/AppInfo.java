package com.fenboshi.fboshi.db;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class AppInfo {

    /**
     * 是否展示引导页
     */
    private boolean showLoadImages = true;

    @Generated(hash = 2029362237)
    public AppInfo(boolean showLoadImages) {
        this.showLoadImages = showLoadImages;
    }

    @Generated(hash = 1656151854)
    public AppInfo() {
    }

    public boolean getShowLoadImages() {
        return this.showLoadImages;
    }

    public void setShowLoadImages(boolean showLoadImages) {
        this.showLoadImages = showLoadImages;
    }

}
