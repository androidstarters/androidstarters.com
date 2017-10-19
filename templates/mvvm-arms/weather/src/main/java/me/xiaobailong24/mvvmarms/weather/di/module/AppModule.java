package <%= appPackage %>.weather.di.module;

import android.app.Application;

import dagger.Module;
import <%= appPackage %>.di.module.ViewModelFactoryModule;

/**
 * Created by xiaobailong24 on 2017/7/22.
 * Dagger AppModule
 */
@Module(includes = {ViewModelFactoryModule.class,
        WeatherViewModelModule.class, WeatherActivityModule.class,
        WeatherNowViewModelModule.class, WeatherNowFragmentModule.class,
        WeatherDailyViewModelModule.class, WeatherDailyFragmentModule.class})
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

}
