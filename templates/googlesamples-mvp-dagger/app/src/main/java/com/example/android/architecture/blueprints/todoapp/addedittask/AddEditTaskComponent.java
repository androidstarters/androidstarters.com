package <%= appPackage %>.addedittask;

import <%= appPackage %>.ToDoApplication;
import <%= appPackage %>.data.source.TasksRepositoryComponent;
import <%= appPackage %>.util.FragmentScoped;

import dagger.Component;

/**
 * This is a Dagger component. Refer to {@link ToDoApplication} for the list of Dagger components
 * used in this application.
 * <P>
 * Because this component depends on the {@link TasksRepositoryComponent}, which is a singleton, a
 * scope must be specified. All fragment components use a custom scope for this purpose.
 */
@FragmentScoped
@Component(dependencies = TasksRepositoryComponent.class,
        modules = AddEditTaskPresenterModule.class)
public interface AddEditTaskComponent {

    void inject(AddEditTaskActivity addEditTaskActivity);
}
