package <%= appPackage %>.weather.di.module;

import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.di.scope.ActivityScope;
import <%= appPackage %>.mvvm.IModel;
import <%= appPackage %>.weather.mvvm.model.WeatherModel;

/**
 * @author xiaobailong24
 * @date 2017/7/31
 * Dagger WeatherModule
 */
@Module
public class WeatherModule {

    @ActivityScope
    @Provides
    public IModel provideMainModel(WeatherModel weatherModel) {
        return weatherModel;
    }
}
