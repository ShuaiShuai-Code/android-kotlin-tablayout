package com.fenboshi.fboshi.component;
import com.fenboshi.fboshi.bean.MainModule;
import com.fenboshi.fboshi.fragment.HomeNewFragment;
import com.fenboshi.fboshi.viewmodel.HomeNewViewModel;

import dagger.Component;

@Component(modules={MainModule.class})
public interface ArticelComPonent {
    void inject(HomeNewViewModel homeNewViewModel);
}
