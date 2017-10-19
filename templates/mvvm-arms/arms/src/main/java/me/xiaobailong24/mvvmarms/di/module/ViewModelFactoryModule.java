package <%= appPackage %>.di.module;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import <%= appPackage %>.mvvm.ViewModelFactory;

/**
 * Created by xiaobailong24 on 2017/7/31.
 * Dagger ViewModelFactoryModule
 */
@Module
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
