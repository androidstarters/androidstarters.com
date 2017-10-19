package <%= appPackage %>.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xiaobailong24 on 2017/6/16.
 * Dagger ActivityScope
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
