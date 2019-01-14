package <%= appPackage %>.ui.injection.module

import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import <%= appPackage %>.data.repository.BufferooRemote
import <%= appPackage %>.remote.BufferooService
import javax.inject.Singleton

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideBufferooRemote(): BufferooRemote {
        return mock()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideBufferooService(): BufferooService {
        return mock()
    }
}