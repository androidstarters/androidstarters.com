package <%= appPackage %>.lifecycle.delegate;


import <%= appPackage %>.lifecycle.di.component.LifecycleComponent;
import <%= appPackage %>.lifecycle.di.module.LifecycleModule;

/**
 * Created by xiaobailong24 on 2017/6/16.
 * Application 继承该接口，就可以具有 LifecycleComponent 提供的方法。
 */
public interface ILifecycle {
    /**
     * Description: 获得全局 LifecycleComponent
     *
     * @return LifecycleComponent
     */
    LifecycleComponent getLifecycleComponent();


    /**
     * Description: 获得全局 LifecycleModule 重用
     *
     * @return LifecycleModule
     */
    LifecycleModule getLifecycleModule();
}
