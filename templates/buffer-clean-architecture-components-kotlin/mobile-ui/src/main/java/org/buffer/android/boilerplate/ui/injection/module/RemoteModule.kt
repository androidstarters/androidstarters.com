package <%= appPackage %>.ui.injection.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import <%= appPackage %>.data.repository.BufferooRemote
import <%= appPackage %>.remote.BufferooRemoteImpl
import <%= appPackage %>.remote.BufferooService
import <%= appPackage %>.remote.BufferooServiceFactory
import <%= appPackage %>.ui.BuildConfig

/**
 * Module that provides all dependencies from the repository package/layer.
 */
@Module
abstract class RemoteModule {

    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideBufferooService(): BufferooService {
            return BufferooServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindBufferooRemote(bufferooRemoteImpl: BufferooRemoteImpl): BufferooRemote
}