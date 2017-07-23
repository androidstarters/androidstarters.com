package <%= appPackage %>.injection.module

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import <%= appPackage %>.data.remote.MvpStarterService
import <%= appPackage %>.data.remote.MvpStarterServiceFactory
import <%= appPackage %>.injection.ApplicationContext

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideMvpStarterService(): MvpStarterService {
        return MvpStarterServiceFactory.makeStarterService()
    }
}
