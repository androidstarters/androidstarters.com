package <%= appPackage %>.injection.component;

import dagger.Subcomponent;
import <%= appPackage %>.features.detail.DetailActivity;
import <%= appPackage %>.features.main.MainActivity;
import <%= appPackage %>.injection.PerActivity;
import <%= appPackage %>.injection.module.ActivityModule;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
