package <%= appPackage %>.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import <%= appPackage %>.base.ArmsInjector;
import <%= appPackage %>.di.module.ArmsConfigModule;
import <%= appPackage %>.di.module.ArmsModule;
import <%= appPackage %>.di.module.ViewModelFactoryModule;
import <%= appPackage %>.http.imageloader.ImageLoader;
import <%= appPackage %>.lifecycle.di.module.LifecycleModule;
import <%= appPackage %>.repository.di.module.RepositoryModule;

/**
 * Created by xiaobailong24 on 2017/7/13.
 * Dagger ArmsComponent
 */
@Singleton
@Component(modules = {ViewModelFactoryModule.class,
        RepositoryModule.class, LifecycleModule.class,
        ArmsModule.class, ArmsConfigModule.class})
public interface ArmsComponent {
    Application application();

    //图片加载管理器，策略模式，默认使用 Glide
    ImageLoader imageLoader();

    void inject(ArmsInjector armsInjector);
}
