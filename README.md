# android-kotlin-tablayout
一个基于kotlin的demo，主要是两个功能，一个是底部导航，使用了BottomNavigationView，首页一个tablayout+viewpager+fragment，
一个小型架构，目前没有数据交互，可以自己扩展，后期会迭代mvvm架构的项目

mvvm架构模式


    Model：实体模型、数据的获取、存储等等

    View：Activity、fragment、view、adapter、xml等等

    ViewModel：负责完成View与Model间的交互和业务逻辑，基于DataBinding改变UI

使用 kotlin，代码更简单
使用 BottomNavigationView，底部导航简单实现
使用 lifeCycle框架管理activity和fragement生命后期
使用 dagger2，解耦
使用dataBinding框架，统一规范处理view
使用greenDao 数据库框架，保存数据到本地会用到

初稿：mvvm设计，目前代码可以实现dagger2管理对象，moudle提供数据，viewmoudle链接moudle和view，以databinding管理view，
显示数据，mvvm架构持续迭代中，如果有问题在这里提问https://github.com/gethub-json/android-kotlin-tablayout


![image](https://github.com/gethub-json/android-kotlin-tablayout/blob/master/app/demo.jpg)