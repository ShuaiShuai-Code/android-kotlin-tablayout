package com.fenboshi.fboshi.component;
import com.fenboshi.fboshi.bean.MainModule;
import com.fenboshi.fboshi.fragment.HomeNewFragment;

import dagger.Component;

@Component(modules={MainModule.class})
public interface UserBeanComPonent {
    void inject(HomeNewFragment homeNewFragment);
}
