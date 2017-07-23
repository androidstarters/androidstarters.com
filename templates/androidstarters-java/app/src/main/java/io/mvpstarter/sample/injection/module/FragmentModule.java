package <%= appPackage %>.injection.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import <%= appPackage %>.injection.ActivityContext;

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    Fragment providesFragment() {
        return fragment;
    }

    @Provides
    Activity provideActivity() {
        return fragment.getActivity();
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return fragment.getActivity();
    }
}
