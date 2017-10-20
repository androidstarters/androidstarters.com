package <%= appPackage %>.lifecycle.di.component;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Component;
import <%= appPackage %>.lifecycle.LifecycleInjector;
import <%= appPackage %>.lifecycle.delegate.AppManager;
import <%= appPackage %>.lifecycle.di.module.LifecycleModule;

/**
 * @author xiaobailong24
 * @date 2017/9/30
 * Dagger LifecycleComponent 向外提供一些方法获取需要的对象，
 * 通过 {@link <%= appPackage %>.lifecycle.utils.LifecycleUtils} 获取
 */
@Singleton
@Component(modules = LifecycleModule.class)
public interface LifecycleComponent {

    /**
     * 用来存取一些整个App公用的数据,切勿大量存放大容量数据
     *
     * @return 全局缓存
     */
    Map<String, Object> extras();

    /**
     * 用于管理所有 Activity
     *
     * @return AppManager
     */
    AppManager appManager();

    /**
     * Dagger 注入
     *
     * @param lifecycleInjector LifecycleInjector
     */
    void inject(LifecycleInjector lifecycleInjector);
}
