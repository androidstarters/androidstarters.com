package <%= appPackage %>.ui.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import <%= appPackage %>.domain.executor.PostExecutionThread
import <%= appPackage %>.domain.repository.BufferooRepository
import <%= appPackage %>.ui.injection.ApplicationComponent
import <%= appPackage %>.ui.injection.module.ActivityBindingModule
import <%= appPackage %>.ui.injection.module.TestApplicationModule
import <%= appPackage %>.ui.injection.scopes.PerApplication
import <%= appPackage %>.ui.test.TestApplication

@Component(modules = arrayOf(TestApplicationModule::class, ActivityBindingModule::class,
        AndroidSupportInjectionModule::class))
@PerApplication
interface TestApplicationComponent : ApplicationComponent {

    fun bufferooRepository(): BufferooRepository

    fun postExecutionThread(): PostExecutionThread

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

}