package <%= appPackage %>.weather.di.module;

import android.app.Application;

import dagger.Module;
import <%= appPackage %>.di.module.ViewModelFactoryModule;

/**
 * @author xiaobailong24
 * @date 2017/7/22
 * Dagger AppModule
 */
@Module(includes = {ViewModelFactoryModule.class,
        WeatherActivityModule.class,
        WeatherNowFragmentModule.class,
        WeatherDailyFragmentModule.class})
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

}
