package <%= appPackage %>.ui.injection.module

import dagger.Binds
import dagger.Module
import <%= appPackage %>.data.BufferooDataRepository
import <%= appPackage %>.data.executor.JobExecutor
import <%= appPackage %>.domain.executor.ThreadExecutor
import <%= appPackage %>.domain.repository.BufferooRepository

@Module
abstract class DataModule {

    @Binds
    abstract fun bindBufferooRepository(bufferooDataRepository: BufferooDataRepository): BufferooRepository

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}