package <%= appPackage %>.data.source;

import <%= appPackage %>.data.FakeTasksRemoteDataSource;
import <%= appPackage %>.data.source.local.TasksLocalDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * This is used by Dagger to inject the required arguments into the {@link TasksRepository}.
 */
@Module
abstract class TasksRepositoryModule {

    @Singleton
    @Binds
    @Local
    abstract TasksDataSource provideTasksLocalDataSource(TasksLocalDataSource dataSource);

    @Singleton
    @Binds
    @Remote
    abstract TasksDataSource provideTasksRemoteDataSource(FakeTasksRemoteDataSource dataSource);
}
