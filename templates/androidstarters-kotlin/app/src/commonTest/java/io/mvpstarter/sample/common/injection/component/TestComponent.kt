package <%= appPackage %>.common.injection.component

import dagger.Component
import <%= appPackage %>.common.injection.module.ApplicationTestModule
import <%= appPackage %>.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : AppComponent