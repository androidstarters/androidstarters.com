package <%= appPackage %>.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import <%= appPackage %>.ui.browse.BrowseActivity
import <%= appPackage %>.ui.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}