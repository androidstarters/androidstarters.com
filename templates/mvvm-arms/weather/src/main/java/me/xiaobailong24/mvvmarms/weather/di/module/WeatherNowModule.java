package <%= appPackage %>.weather.di.module;

import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.di.scope.FragmentScope;
import <%= appPackage %>.mvvm.IModel;
import <%= appPackage %>.weather.R;
import <%= appPackage %>.weather.mvvm.model.WeatherNowModel;
import <%= appPackage %>.weather.mvvm.view.adapter.TextContentAdapter;

/**
 * @author xiaobailong24
 * @date 2017/7/15
 * Dagger WeatherNowModule
 */
@Module
public class WeatherNowModule {

    @FragmentScope
    @Provides
    IModel provideWeatherNowModel(WeatherNowModel weatherNowModel) {
        return weatherNowModel;
    }

    @FragmentScope
    @Provides
    TextContentAdapter provideAdapter() {
        return new TextContentAdapter(R.layout.super_text_item, null);
    }

}
