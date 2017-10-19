package <%= appPackage %>.weather.di.module;

import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.di.scope.FragmentScope;
import <%= appPackage %>.mvvm.IModel;
import <%= appPackage %>.weather.mvvm.model.WeatherNowModel;

/**
 * Created by xiaobailong24 on 2017/7/15.
 * Dagger WeatherNowModule
 */
@Module
public class WeatherNowModule {

    @FragmentScope
    @Provides
    public IModel provideWeatherNowModel(WeatherNowModel weatherNowModel) {
        return weatherNowModel;
    }

}
