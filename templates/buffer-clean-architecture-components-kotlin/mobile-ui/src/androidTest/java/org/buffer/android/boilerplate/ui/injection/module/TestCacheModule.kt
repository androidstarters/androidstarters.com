package <%= appPackage %>.ui.injection.module

import android.app.Application
import android.arch.persistence.room.Room
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import <%= appPackage %>.cache.PreferencesHelper
import <%= appPackage %>.cache.db.BufferoosDatabase
import <%= appPackage %>.data.repository.BufferooCache
import javax.inject.Singleton

@Module
object TestCacheModule {

    @Provides
    @JvmStatic
    fun provideBufferoosDatabase(application: Application): BufferoosDatabase {
        return Room.databaseBuilder(
                application.applicationContext,
                BufferoosDatabase::class.java, "bufferoos.db")
                .build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideBufferooCache(): BufferooCache {
        return mock()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun providePreferencesHelper(): PreferencesHelper {
        return mock()
    }

}