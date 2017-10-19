package <%= appPackage %>.lifecycle.di.component;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Component;
import <%= appPackage %>.lifecycle.LifecycleInjector;
import <%= appPackage %>.lifecycle.delegate.AppManager;
import <%= appPackage %>.lifecycle.di.module.LifecycleModule;

/**
 * Created by xiaobailong24 on 2017/9/30.
 * Dagger LifecycleComponent
 */
@Singleton
@Component(modules = LifecycleModule.class)
public interface LifecycleComponent {

    //用来存取一些整个App公用的数据,切勿大量存放大容量数据
    Map<String, Object> extras();

    //用于管理所有activity
    AppManager appManager();

    void inject(LifecycleInjector lifecycleInjector);
}
