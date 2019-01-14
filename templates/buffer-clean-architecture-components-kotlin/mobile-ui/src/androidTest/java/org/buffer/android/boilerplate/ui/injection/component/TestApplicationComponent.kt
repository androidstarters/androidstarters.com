package <%= appPackage %>.ui.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import <%= appPackage %>.domain.executor.PostExecutionThread
import <%= appPackage %>.domain.repository.BufferooRepository
import <%= appPackage %>.ui.injection.ApplicationComponent
import <%= appPackage %>.ui.injection.module.*
import <%= appPackage %>.ui.injection.scopes.PerApplication
import <%= appPackage %>.ui.test.TestApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        TestApplicationModule::class,
        AndroidSupportInjectionModule::class,
        TestCacheModule::class,
        TestRemoteModule::class,
        TestDataModule::class,
        PresentationModule::class,
        UiModule::class))
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