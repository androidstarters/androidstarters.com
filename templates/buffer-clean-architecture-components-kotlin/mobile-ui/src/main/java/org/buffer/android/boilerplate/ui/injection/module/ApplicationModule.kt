package <%= appPackage %>.ui.injection.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import <%= appPackage %>.cache.BufferooCacheImpl
import <%= appPackage %>.cache.PreferencesHelper
import <%= appPackage %>.cache.db.BufferoosDatabase
import <%= appPackage %>.cache.mapper.BufferooEntityMapper
import <%= appPackage %>.data.BufferooDataRepository
import <%= appPackage %>.data.executor.JobExecutor
import <%= appPackage %>.data.mapper.BufferooMapper
import <%= appPackage %>.data.repository.BufferooCache
import <%= appPackage %>.data.repository.BufferooRemote
import <%= appPackage %>.data.source.BufferooDataStoreFactory
import <%= appPackage %>.domain.executor.PostExecutionThread
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.BufferooRepository
import <%= appPackage %>.remote.BufferooRemoteImpl
import <%= appPackage %>.remote.BufferooService
import <%= appPackage %>.remote.BufferooServiceFactory
import <%= appPackage %>.ui.BuildConfig
import <%= appPackage %>.ui.UiThread
import <%= appPackage %>.ui.injection.scopes.PerApplication

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context
}
