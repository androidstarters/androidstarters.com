package <%= appPackage %>.injection.component

import <%= appPackage %>.injection.PerFragment
import <%= appPackage %>.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent