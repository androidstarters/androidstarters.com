package <%= appPackage %>.ui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import <%= appPackage %>.domain.executor.PostExecutionThread
import javax.inject.Inject

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
class UiThread @Inject internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}