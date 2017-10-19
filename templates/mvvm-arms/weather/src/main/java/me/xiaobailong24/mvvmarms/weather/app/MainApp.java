package <%= appPackage %>.weather.app;

import <%= appPackage %>.base.ArmsApplication;
import <%= appPackage %>.weather.di.component.AppComponent;
import <%= appPackage %>.weather.di.component.DaggerAppComponent;

/**
 * Created by xiaobailong24 on 2017/7/13.
 */

public class MainApp extends ArmsApplication {

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
