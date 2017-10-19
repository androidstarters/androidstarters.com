package <%= appPackage %>.repository.utils;

import android.app.Application;
import android.content.Context;

import <%= appPackage %>.repository.IRepository;
import <%= appPackage %>.repository.di.component.RepositoryComponent;

/**
 * Created by xiaobailong24 on 2017/9/28.
 * RepositoryComponent 工具类
 */
public enum RepositoryUtils {
    INSTANCE;

    public RepositoryComponent obtainRepositoryComponent(Context context) {
        return obtainRepositoryComponent((Application) context.getApplicationContext());
    }

    public RepositoryComponent obtainRepositoryComponent(Application application) {
        Preconditions.checkState(application instanceof IRepository,
                "%s does not implements IRepository", application.getClass().getName());
        return ((IRepository) application).getRepositoryComponent();
    }

}
