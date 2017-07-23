package <%= appPackage %>.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import <%= appPackage %>.common.injection.module.ApplicationTestModule;
import <%= appPackage %>.injection.component.AppComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends AppComponent {
}
