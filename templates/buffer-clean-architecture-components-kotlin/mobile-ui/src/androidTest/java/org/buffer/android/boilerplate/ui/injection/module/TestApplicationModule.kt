package <%= appPackage %>.ui.injection.module

import android.app.Application
import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
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
abstract class TestApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context
}