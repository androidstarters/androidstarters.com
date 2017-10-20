package <%= appPackage %>.weather.di.component;

import dagger.Component;
import <%= appPackage %>.di.component.ArmsComponent;
import <%= appPackage %>.di.scope.AppScope;
import <%= appPackage %>.weather.app.MainApp;
import <%= appPackage %>.weather.di.module.AppModule;

/**
 * @author xiaobailong24
 * @date 2017/7/15
 * Dagger AppComponent
 */
@AppScope
@Component(dependencies = ArmsComponent.class,
        modules = AppModule.class)
public interface AppComponent {
    /**
     * Dagger 注入
     *
     * @param mainApp MainApp
     */
    void inject(MainApp mainApp);
}
