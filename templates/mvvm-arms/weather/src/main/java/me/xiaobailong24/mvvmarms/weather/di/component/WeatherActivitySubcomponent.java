package <%= appPackage %>.weather.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import <%= appPackage %>.di.scope.ActivityScope;
import <%= appPackage %>.weather.di.module.WeatherModule;
import <%= appPackage %>.weather.mvvm.view.activity.WeatherActivity;

/**
 * Created by xiaobailong24 on 2017/7/13.
 * Dagger WeatherActivitySubcomponent
 */
@ActivityScope
@Subcomponent(modules = WeatherModule.class)///DataModule
public interface WeatherActivitySubcomponent extends AndroidInjector<WeatherActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<WeatherActivity> {
    }
}
