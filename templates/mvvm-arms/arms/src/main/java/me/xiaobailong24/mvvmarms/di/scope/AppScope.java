package <%= appPackage %>.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xiaobailong24 on 2017/7/24.
 */

@Scope
@Retention(RUNTIME)
public @interface AppScope {
}