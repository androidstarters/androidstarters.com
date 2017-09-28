package <%= appPackage %>.ui.injection.module

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.content.Context
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
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(factory: BufferooDataStoreFactory,
                                           mapper: BufferooMapper): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(database: BufferoosDatabase,
                                      entityMapper: BufferooEntityMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(database, entityMapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: BufferooService,
                                       factory: <%= appPackage %>.remote.mapper.BufferooEntityMapper): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
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
        return BufferooServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
    }

    @Provides
    @PerApplication
    internal fun provideViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelProvider.NewInstanceFactory()
    }

    @Provides
    @PerApplication
    internal fun provideBufferoosDatabase(application: Application): BufferoosDatabase {
        return Room.databaseBuilder(application.applicationContext,
                BufferoosDatabase::class.java, "bufferoos.db")
                .build()
    }

}
