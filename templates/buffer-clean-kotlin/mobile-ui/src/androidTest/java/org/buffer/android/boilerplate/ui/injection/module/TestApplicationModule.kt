package <%= appPackage %>.ui.injection.module

import android.app.Application
import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import <%= appPackage %>.cache.PreferencesHelper
import <%= appPackage %>.data.executor.JobExecutor
import <%= appPackage %>.data.repository.BufferooCache
import <%= appPackage %>.data.repository.BufferooRemote
import <%= appPackage %>.domain.executor.PostExecutionThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.BufferooRepository
import <%= appPackage %>.remote.BufferooService
import <%= appPackage %>.ui.UiThread
import <%= appPackage %>.ui.injection.scopes.PerApplication

@Module
class TestApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(): PreferencesHelper {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRepository(): BufferooRepository {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(): BufferooCache {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(): BufferooRemote {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): BufferooService {
        return mock()
    }

}