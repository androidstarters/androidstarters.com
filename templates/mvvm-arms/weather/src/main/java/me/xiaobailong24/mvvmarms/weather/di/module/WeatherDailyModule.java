package <%= appPackage %>.weather.di.module;

import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.di.scope.FragmentScope;
import <%= appPackage %>.mvvm.IModel;
import <%= appPackage %>.weather.R;
import <%= appPackage %>.weather.mvvm.model.WeatherDailyModel;
import <%= appPackage %>.weather.mvvm.view.adapter.WeatherDailyAdapter;

/**
 * @author xiaobailong24
 * @date 2017/8/14
 * Dagger WeatherDailyModule
 */
@Module
public class WeatherDailyModule {

    @FragmentScope
    @Provides
    IModel provideWeatherDailyModel(WeatherDailyModel weatherDailyModel) {
        return weatherDailyModel;
    }

    @FragmentScope
    @Provides
    WeatherDailyAdapter provideAdapter() {
        return new WeatherDailyAdapter(R.layout.super_item_daily, null);
    }
}
