package <%= appPackage %>.weather.di.module;

import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.di.scope.FragmentScope;
import <%= appPackage %>.mvvm.IModel;
import <%= appPackage %>.weather.mvvm.model.WeatherDailyModel;

/**
 * Created by xiaobailong24 on 2017/8/14.
 * Dagger WeatherDailyModule
 */
@Module
public class WeatherDailyModule {

    @FragmentScope
    @Provides
    public IModel provideWeatherDailyModel(WeatherDailyModel weatherDailyModel) {
        return weatherDailyModel;
    }
}
