package <%= appPackage %>.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import <%= appPackage %>.data.DataManager;
import <%= appPackage %>.injection.ApplicationContext;
import <%= appPackage %>.injection.module.AppModule;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

    DataManager apiManager();
}
