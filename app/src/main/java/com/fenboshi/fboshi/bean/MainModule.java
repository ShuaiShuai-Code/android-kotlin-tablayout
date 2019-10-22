package com.fenboshi.fboshi.bean;

import com.fenboshi.fboshi.viewmodel.ArticelRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    UserBean provUserBean(){
        return  new UserBean();
    }

    @Provides
    ArticelRepository provArticeRepository(){
        return  new ArticelRepository();
    }
}
