package <%= appPackage %>.repository;

import android.app.Application;
import android.content.Context;

import java.util.List;

import <%= appPackage %>.repository.di.component.DaggerRepositoryComponent;
import <%= appPackage %>.repository.di.component.RepositoryComponent;
import <%= appPackage %>.repository.di.module.ClientModule;
import <%= appPackage %>.repository.di.module.RepositoryConfigModule;
import <%= appPackage %>.repository.di.module.RepositoryModule;
import <%= appPackage %>.repository.utils.ManifestRepositoryParser;
import <%= appPackage %>.repository.utils.Preconditions;

/**
 * Created by xiaobailong24 on 2017/9/28.
 * RepositoryInjector，需要在 Application 初始化，注入 RepositoryComponent
 */
public class RepositoryInjector implements IRepository {
    private Application mApplication;
    private List<ConfigRepository> mConfigRepositories;
    private RepositoryComponent mRepositoryComponent;
    private RepositoryModule mRepositoryModule;

    public RepositoryInjector(Context context) {
        mConfigRepositories = new ManifestRepositoryParser(context).parse();
    }

    public void onCreate(Application application) {
        this.mApplication = application;
        if (mRepositoryModule == null)
            mRepositoryModule = new RepositoryModule(mApplication);
        mRepositoryComponent = DaggerRepositoryComponent.builder()
                .repositoryModule(mRepositoryModule)
                .clientModule(new ClientModule(mApplication))
                .repositoryConfigModule(getRepositoryConfigModule(mApplication, mConfigRepositories))
                .build();
        mRepositoryComponent.inject(this);
    }

    public void onTerminate(Application application) {
        this.mRepositoryModule = null;
        this.mRepositoryComponent = null;
        this.mConfigRepositories = null;
        this.mApplication = null;
    }

    private RepositoryConfigModule getRepositoryConfigModule(Context context, List<ConfigRepository> configRepositories) {
        RepositoryConfigModule.Builder builder = RepositoryConfigModule.builder();
        for (ConfigRepository repository : configRepositories)
            repository.applyOptions(context, builder);
        return builder.application(mApplication).build();
    }

    public RepositoryComponent getRepositoryComponent() {
        Preconditions.checkNotNull(mRepositoryComponent,
                "%s cannot be null,first call %s#onCreate(Application) in %s#onCreate()",
                RepositoryComponent.class.getName(), getClass().getName(), mApplication.getClass().getName());
        return this.mRepositoryComponent;
    }

    public RepositoryModule getRepositoryModule() {
        Preconditions.checkNotNull(mRepositoryComponent,
                "%s cannot be null,first call %s#onCreate(Application) in %s#onCreate()",
                RepositoryModule.class.getName(), getClass().getName(), mApplication.getClass().getName());
        return this.mRepositoryModule;
    }
}
