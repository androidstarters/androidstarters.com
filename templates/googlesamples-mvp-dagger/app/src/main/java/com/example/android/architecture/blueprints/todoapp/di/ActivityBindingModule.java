package <%= appPackage %>.di;

import <%= appPackage %>.addedittask.AddEditTaskModule;
import <%= appPackage %>.addedittask.AddEditTaskActivity;
import <%= appPackage %>.statistics.StatisticsActivity;
import <%= appPackage %>.statistics.StatisticsModule;
import <%= appPackage %>.taskdetail.TaskDetailActivity;
import <%= appPackage %>.taskdetail.TaskDetailPresenterModule;
import <%= appPackage %>.tasks.TasksActivity;
import <%= appPackage %>.tasks.TasksModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = TasksModule.class)
    abstract TasksActivity tasksActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = AddEditTaskModule.class)
    abstract AddEditTaskActivity addEditTaskActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = StatisticsModule.class)
    abstract StatisticsActivity statisticsActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = TaskDetailPresenterModule.class)
    abstract TaskDetailActivity taskDetailActivity();
}
