package com.fenboshi.fboshi.db;

import android.database.sqlite.SQLiteDatabase;

import com.fenboshi.fboshi.MyApplication;
import com.fenboshi.fboshi.bean.UserBean;
import com.fenboshi.fboshi.greendao.gen.DaoMaster;
import com.fenboshi.fboshi.greendao.gen.DaoSession;


public class DaoManager {

    private static final String DB_NAME = "mould.db";


    private static final class Manager {
        private static final DaoManager mDaoManager = new DaoManager();

    }

    private static final class DaoInstance {

        private static final DaoMaster.DevOpenHelper mHelper =
                new DaoMaster.DevOpenHelper(MyApplication.Companion.getApplication(),
                        DB_NAME, null);
        private static final SQLiteDatabase db = mHelper.getWritableDatabase();
        private static final DaoMaster mDaoMaster = new DaoMaster(db);
        private static final DaoSession mDaoSession = mDaoMaster.newSession();
    }

    public static DaoManager getInstance() {
        return Manager.mDaoManager;
    }


    private DaoSession getDaoSession() {
        return DaoInstance.mDaoSession;
    }

    public void logout() {
        getDaoSession().deleteAll(UserBean.class);
    }

    public AppInfo getAppInfo() {
        return getDaoSession().queryBuilder(AppInfo.class).build().unique();
    }

    public void saveAppInfo(AppInfo appInfo) {

        getDaoSession().getAppInfoDao().detachAll();
        getDaoSession().getAppInfoDao().insertOrReplace(appInfo);
    }


    public UserBean getUserBean() {
        return getDaoSession().queryBuilder(UserBean.class).build().unique();
    }

    public void saveUserBean(UserBean userBean) {
        getDaoSession().deleteAll(UserBean.class);
        getDaoSession().getUserBeanDao().detachAll();
        getDaoSession().getUserBeanDao().insertOrReplace(userBean);
    }

    //    /**
//     * 更新支付密码设置状态
//     */
//    public void setIsSecurity(boolean b) {
//        UserEntity userEntity = getUserEntity();
//        userEntity.setIsSecurity(b);
//        saveUserEntity(userEntity);
//    }
//
//    /**
//     * 更新身份角色状态
//     */
//    public void setRole(int role) {
//        UserEntity userEntity = getUserEntity();
//        userEntity.setRoleType(role);
//        saveUserEntity(userEntity);
//    }
//
    //更新昵称
    public void setNickName(String nickName) {
        UserBean userEntity = getUserBean();
        userEntity.setNickName(nickName);
        saveUserBean(userEntity);
    }

    //
    //更新头像
    public void setAvatalUrl(String avatalUrl) {
        UserBean userEntity = getUserBean();
        userEntity.setAvatarUrl(avatalUrl);
        saveUserBean(userEntity);
    }

    //更新性别
    public void setGender(int sex) {
        UserBean userEntity = getUserBean();
        userEntity.setSex(sex);
        saveUserBean(userEntity);
    }


    //更新出生日期
    public void setBirthday(String birthday) {
        UserBean userEntity = getUserBean();
        userEntity.setBirthday(birthday);
        saveUserBean(userEntity);
    }


//
//    /**
//     * 设置实名认证状态
//     */
//    public void setIsReal(boolean isReal) {
//        UserBean userBean = getUserBean();
//        userBean.setReal(isReal);
//        saveUserBean(userBean);
//    }
//
//    public void setRealName(String realName) {
//        UserBean userBean = getUserBean();
//        userBean.setRealName(realName);
//        saveUserBean(userBean);
//    }
////--------
//    public void setBackIdCard(String backIdCard) {
//        UserBean userBean = getUserBean();
//        userBean.setBackIdcardPic(backIdCard);
//        saveUserBean(userBean);
//    }
//
//    public void setFrontIdCard(String frontIdCard) {
//        UserBean userBean = getUserBean();
//        userBean.setFrontIdcardPic(frontIdCard);
//        saveUserBean(userBean);
//    }
//
//    public void setIdnumber(String idNumber) {
//        UserBean userBean = getUserBean();
//        userBean.setIdCardNumber(idNumber);
//        saveUserBean(userBean);
//    }
//    public void setIdBirthday(String idNumber) {
//        UserBean userBean = getUserBean();
//        userBean.setIdCardBirthday(idNumber);
//        saveUserBean(userBean);
//    }
//
//    public void setIdSex(int sex) {
//        UserBean userBean = getUserBean();
//        userBean.setIdCardSex(sex);
//        saveUserBean(userBean);
//    }
//
//    public void setIdCardRealName(String realName) {
//        UserBean userBean = getUserBean();
//        userBean.setIdCardName(realName);
//        saveUserBean(userBean);
//    }
//    //---------
//
//    public void setCompanyName(String str){
//        UserBean userBean = getUserBean();
//        userBean.setCompanyName(str);
//        saveUserBean(userBean);
//    }
//
//    public void setIsPerfect(boolean b) {
//        UserBean userBean = getUserBean();
//        userBean.setIsPerfectInfo(b);
//        saveUserBean(userBean);
//    }
//
//    public void setRole(int role) {
//        UserBean userBean = getUserBean();
//        userBean.setRoleType(role);
//        saveUserBean(userBean);
//    }
//
//    public void setReceiptCode(String code){
//        UserBean userBean = getUserBean();
//        userBean.setReceiptCode(code);
//        saveUserBean(userBean);
//    }
//
//    public void setServcePhone(String phone){
//        UserBean userBean = getUserBean();
//        userBean.setCompanyServerPhone(phone);
//        saveUserBean(userBean);
//    }
//
//
//    public void setTeamCode(String teamCode) {
//        UserBean userBean = getUserBean();
//        userBean.setTeamCode(teamCode);
//        saveUserBean(userBean);
//    }
//    public void setTeamName(String teamName) {
//        UserBean userBean = getUserBean();
//        userBean.setTeamName(teamName);
//        saveUserBean(userBean);
//    }


//    public void logout() {
//        getDaoSession().deleteAll(UserEntity.class);
//    }

}
