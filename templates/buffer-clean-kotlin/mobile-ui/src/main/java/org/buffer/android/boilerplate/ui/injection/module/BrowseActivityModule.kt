package <%= appPackage %>.ui.injection.module

import dagger.Module
import dagger.Provides
import <%= appPackage %>.domain.interactor.browse.GetBufferoos
import <%= appPackage %>.presentation.browse.BrowseBufferoosContract
import <%= appPackage %>.presentation.browse.BrowseBufferoosPresenter
import <%= appPackage %>.presentation.mapper.BufferooMapper
import <%= appPackage %>.ui.browse.BrowseActivity
import <%= appPackage %>.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseBufferoosContract.View,
                                        getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
