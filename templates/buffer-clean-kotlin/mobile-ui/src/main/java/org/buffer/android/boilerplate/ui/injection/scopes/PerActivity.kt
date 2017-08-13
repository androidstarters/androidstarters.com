package <%= appPackage %>.ui.injection.scopes

import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity