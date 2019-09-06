package com.fenboshi.fboshi.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.fenboshi.fboshi.bean.UserBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_BEAN".
*/
public class UserBeanDao extends AbstractDao<UserBean, Void> {

    public static final String TABLENAME = "USER_BEAN";

    /**
     * Properties of entity UserBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property AccessToken = new Property(0, String.class, "accessToken", false, "ACCESS_TOKEN");
        public final static Property DeviceId = new Property(1, String.class, "deviceId", false, "DEVICE_ID");
        public final static Property Id = new Property(2, int.class, "id", false, "ID");
        public final static Property Mobile = new Property(3, String.class, "mobile", false, "MOBILE");
        public final static Property NickName = new Property(4, String.class, "nickName", false, "NICK_NAME");
        public final static Property AvatarUrl = new Property(5, String.class, "avatarUrl", false, "AVATAR_URL");
        public final static Property Sex = new Property(6, int.class, "sex", false, "SEX");
        public final static Property Birthday = new Property(7, String.class, "birthday", false, "BIRTHDAY");
    }


    public UserBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UserBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_BEAN\" (" + //
                "\"ACCESS_TOKEN\" TEXT," + // 0: accessToken
                "\"DEVICE_ID\" TEXT," + // 1: deviceId
                "\"ID\" INTEGER NOT NULL ," + // 2: id
                "\"MOBILE\" TEXT," + // 3: mobile
                "\"NICK_NAME\" TEXT," + // 4: nickName
                "\"AVATAR_URL\" TEXT," + // 5: avatarUrl
                "\"SEX\" INTEGER NOT NULL ," + // 6: sex
                "\"BIRTHDAY\" TEXT);"); // 7: birthday
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        String accessToken = entity.getAccessToken();
        if (accessToken != null) {
            stmt.bindString(1, accessToken);
        }
 
        String deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindString(2, deviceId);
        }
        stmt.bindLong(3, entity.getId());
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(4, mobile);
        }
 
        String nickName = entity.getNickName();
        if (nickName != null) {
            stmt.bindString(5, nickName);
        }
 
        String avatarUrl = entity.getAvatarUrl();
        if (avatarUrl != null) {
            stmt.bindString(6, avatarUrl);
        }
        stmt.bindLong(7, entity.getSex());
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(8, birthday);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        String accessToken = entity.getAccessToken();
        if (accessToken != null) {
            stmt.bindString(1, accessToken);
        }
 
        String deviceId = entity.getDeviceId();
        if (deviceId != null) {
            stmt.bindString(2, deviceId);
        }
        stmt.bindLong(3, entity.getId());
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(4, mobile);
        }
 
        String nickName = entity.getNickName();
        if (nickName != null) {
            stmt.bindString(5, nickName);
        }
 
        String avatarUrl = entity.getAvatarUrl();
        if (avatarUrl != null) {
            stmt.bindString(6, avatarUrl);
        }
        stmt.bindLong(7, entity.getSex());
 
        String birthday = entity.getBirthday();
        if (birthday != null) {
            stmt.bindString(8, birthday);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public UserBean readEntity(Cursor cursor, int offset) {
        UserBean entity = new UserBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // accessToken
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // deviceId
            cursor.getInt(offset + 2), // id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // mobile
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // nickName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // avatarUrl
            cursor.getInt(offset + 6), // sex
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // birthday
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserBean entity, int offset) {
        entity.setAccessToken(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDeviceId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setId(cursor.getInt(offset + 2));
        entity.setMobile(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setNickName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAvatarUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSex(cursor.getInt(offset + 6));
        entity.setBirthday(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(UserBean entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(UserBean entity) {
        return null;
    }

    @Override
    public boolean hasKey(UserBean entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}