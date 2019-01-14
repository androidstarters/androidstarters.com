package <%= appPackage %>.ui.injection.module

import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
import dagger.Module
import dagger.Provides
import <%= appPackage %>.data.executor.JobExecutor
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.BufferooRepository
import javax.inject.Singleton

@Module
abstract class TestDataModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @Singleton
        fun provideBufferooRepository(): BufferooRepository {
            return mock()
        }
    }

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}
