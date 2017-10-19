package <%= appPackage %>.weather.di.module;

import android.arch.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import <%= appPackage %>.di.scope.ViewModelScope;
import <%= appPackage %>.weather.mvvm.viewmodel.WeatherViewModel;

/**
 * Created by xiaobailong24 on 2017/7/31.
 * Dagger WeatherViewModelModule
 * 包含ViewModelFactoryModule提供ViewModelProvider.Factory
 */
@Module(includes = {WeatherModule.class})
public abstract class WeatherViewModelModule {

    @Binds
    @IntoMap
    @ViewModelScope(WeatherViewModel.class)
    abstract ViewModel bindWeatherViewModel(WeatherViewModel weatherViewModel);

    //    @Binds
    //    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
