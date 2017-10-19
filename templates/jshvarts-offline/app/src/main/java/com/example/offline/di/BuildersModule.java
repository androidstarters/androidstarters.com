package <%= appPackage %>.di;

import <%= appPackage %>.view.CommentsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = CommentsActivityModule.class)
    abstract CommentsActivity bindCommentsActivity();

    // Add bindings for other sub-components here
}
