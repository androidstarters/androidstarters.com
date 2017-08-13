package <%= appPackage %>.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import <%= appPackage %>.ui.BufferooApplication
import <%= appPackage %>.ui.injection.module.ActivityBindingModule
import <%= appPackage %>.ui.injection.module.ApplicationModule
import <%= appPackage %>.ui.injection.scopes.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: BufferooApplication)

}
