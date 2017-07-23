package <%= appPackage %>.common.injection.component

import <%= appPackage %>.common.injection.module.ApplicationTestModule
import <%= appPackage %>.injection.component.ApplicationComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationTestModule::class))
interface TestComponent : ApplicationComponent