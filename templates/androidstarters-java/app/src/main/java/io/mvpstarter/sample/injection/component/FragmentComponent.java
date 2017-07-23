package <%= appPackage %>.injection.component;

import dagger.Subcomponent;
import <%= appPackage %>.injection.PerFragment;
import <%= appPackage %>.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
