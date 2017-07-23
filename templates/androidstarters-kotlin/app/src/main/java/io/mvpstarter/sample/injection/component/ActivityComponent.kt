package <%= appPackage %>.injection.component

import <%= appPackage %>.injection.PerActivity
import <%= appPackage %>.injection.module.ActivityModule
import <%= appPackage %>.features.base.BaseActivity
import <%= appPackage %>.features.detail.DetailActivity
import <%= appPackage %>.features.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
