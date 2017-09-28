package <%= appPackage %>.ui.injection.module

import dagger.Module
import dagger.Provides
import <%= appPackage %>.domain.interactor.browse.GetBufferoos
import <%= appPackage %>.presentation.browse.BrowseBufferoosViewModelFactory
import <%= appPackage %>.presentation.mapper.BufferooMapper


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @Provides
    fun provideBrowseBufferoosViewModelFactory(getBufferoos: GetBufferoos,
                                               bufferooMapper: BufferooMapper):
            BrowseBufferoosViewModelFactory {
        return BrowseBufferoosViewModelFactory(getBufferoos, bufferooMapper)
    }

}
