package <%= appPackage %>.lifecycle.utils;

import android.app.Application;
import android.content.Context;

import <%= appPackage %>.lifecycle.delegate.ILifecycle;
import <%= appPackage %>.lifecycle.di.component.LifecycleComponent;

/**
 * @author xiaobailong24
 * @date 2017/9/28
 * LifecycleComponent 工具类
 */
public enum LifecycleUtils {
    /**
     * 单例模式的枚举实现
     */
    INSTANCE;

    /**
     * 获取 {@link LifecycleComponent}，使用 Dagger 对外暴露的方法
     *
     * @param context Context
     * @return LifecycleComponent
     */
    public LifecycleComponent obtainLifecycleComponent(Context context) {
        return obtainLifecycleComponent((Application) context.getApplicationContext());
    }

    /**
     * 获取 {@link LifecycleComponent}，使用 Dagger 对外暴露的方法
     *
     * @param application Application
     * @return LifecycleComponent
     */
    public LifecycleComponent obtainLifecycleComponent(Application application) {
        Preconditions.checkState(application instanceof ILifecycle,
                "%s does not implements ILifecycle", application.getClass().getName());
        return ((ILifecycle) application).getLifecycleComponent();
    }

}
