package <%= appPackage %>.injection.component

import <%= appPackage %>.data.DataManager
import <%= appPackage %>.data.remote.MvpStarterService
import <%= appPackage %>.injection.ApplicationContext
import <%= appPackage %>.injection.module.ApplicationModule
import android.app.Application
import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun mvpBoilerplateService(): MvpStarterService
}
