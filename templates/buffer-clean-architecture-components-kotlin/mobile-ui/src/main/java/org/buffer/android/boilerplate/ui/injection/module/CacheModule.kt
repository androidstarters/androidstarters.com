package <%= appPackage %>.ui.injection.module

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import <%= appPackage %>.cache.BufferooCacheImpl
import <%= appPackage %>.cache.db.BufferoosDatabase
import <%= appPackage %>.data.repository.BufferooCache

/**
 * Module that provides all dependencies from the cache package/layer.
 */
@Module
abstract class CacheModule {

    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */
    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideBufferoosDatabase(application: Application): BufferoosDatabase {
            return Room.databaseBuilder(
                    application.applicationContext,
                    BufferoosDatabase::class.java, "bufferoos.db")
                    .build()
        }
    }

    @Binds
    abstract fun bindBufferooCache(bufferooCacheImpl: BufferooCacheImpl): BufferooCache
}
