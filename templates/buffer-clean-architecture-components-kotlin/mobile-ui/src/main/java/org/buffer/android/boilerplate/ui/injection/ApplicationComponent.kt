package <%= appPackage %>.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import <%= appPackage %>.ui.BufferooApplication
import <%= appPackage %>.ui.injection.module.*
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        CacheModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
        RemoteModule::class,
        UiModule::class)
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: BufferooApplication)

}
