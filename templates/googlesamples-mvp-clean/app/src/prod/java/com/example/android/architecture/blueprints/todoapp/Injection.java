/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package <%= appPackage %>;

import static com.google.common.base.Preconditions.checkNotNull;

import android.content.Context;
import android.support.annotation.NonNull;

import <%= appPackage %>.addedittask.domain.usecase.DeleteTask;
import <%= appPackage %>.addedittask.domain.usecase.GetTask;
import <%= appPackage %>.addedittask.domain.usecase.SaveTask;
import <%= appPackage %>.data.source.TasksDataSource;
import <%= appPackage %>.data.source.TasksRepository;
import <%= appPackage %>.data.source.local.TasksLocalDataSource;
import <%= appPackage %>.data.source.remote.TasksRemoteDataSource;
import <%= appPackage %>.statistics.domain.usecase.GetStatistics;
import <%= appPackage %>.tasks.domain.filter.FilterFactory;
import <%= appPackage %>.tasks.domain.usecase.ActivateTask;
import <%= appPackage %>.tasks.domain.usecase.ClearCompleteTasks;
import <%= appPackage %>.tasks.domain.usecase.CompleteTask;
import <%= appPackage %>.tasks.domain.usecase.GetTasks;

/**
 * Enables injection of production implementations for
 * {@link TasksDataSource} at compile time.
 */
public class Injection {

    public static TasksRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        return TasksRepository.getInstance(TasksRemoteDataSource.getInstance(),
                TasksLocalDataSource.getInstance(context));
    }

    public static GetTasks provideGetTasks(@NonNull Context context) {
        return new GetTasks(provideTasksRepository(context), new FilterFactory());
    }

    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

    public static GetTask provideGetTask(Context context) {
        return new GetTask(Injection.provideTasksRepository(context));
    }

    public static SaveTask provideSaveTask(Context context) {
        return new SaveTask(Injection.provideTasksRepository(context));
    }

    public static CompleteTask provideCompleteTasks(Context context) {
        return new CompleteTask(Injection.provideTasksRepository(context));
    }

    public static ActivateTask provideActivateTask(Context context) {
        return new ActivateTask(Injection.provideTasksRepository(context));
    }

    public static ClearCompleteTasks provideClearCompleteTasks(Context context) {
        return new ClearCompleteTasks(Injection.provideTasksRepository(context));
    }

    public static DeleteTask provideDeleteTask(Context context) {
        return new DeleteTask(Injection.provideTasksRepository(context));
    }

    public static GetStatistics provideGetStatistics(Context context) {
        return new GetStatistics(Injection.provideTasksRepository(context));
    }
}
