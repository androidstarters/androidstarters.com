package <%= appPackage %>.ui.injection.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import <%= appPackage %>.domain.executor.PostExecutionThread
import <%= appPackage %>.ui.UiThread
import <%= appPackage %>.ui.browse.BrowseActivity

/**
 * Module that provides all dependencies from the mobile-ui package/layer and injects all activities.
 */
@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): BrowseActivity
}