package <%= appPackage %>.weather.app;

import <%= appPackage %>.base.BaseApplication;
import <%= appPackage %>.weather.di.component.AppComponent;
import <%= appPackage %>.weather.di.component.DaggerAppComponent;

/**
 * @author xiaobailong24
 * @date 2017/7/13
 * MainApp 配置框架
 * {@link BaseApplication}
 */
public class MainApp extends BaseApplication {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent
                .builder()
                .armsComponent(getArmsComponent())
                .build();
        mAppComponent.inject(this);
    }


    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }

}
