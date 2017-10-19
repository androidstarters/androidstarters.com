package <%= appPackage %>.repository.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import <%= appPackage %>.repository.IRepositoryManager;
import <%= appPackage %>.repository.RepositoryManager;
import <%= appPackage %>.repository.cache.Cache;
import <%= appPackage %>.repository.cache.CacheType;
import retrofit2.Retrofit;

/**
 * Created by xiaobailong24 on 2017/9/28.
 * Dagger RepositoryModule
 */
@Module
public class RepositoryModule {
    private Application mApplication;

    public RepositoryModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    IRepositoryManager provideRepositoryManager(Lazy<Retrofit> retrofit, Lazy<RxCache> rxCache,
                                                Cache.Factory cacheFactory,
                                                DBModule.RoomConfiguration roomConfiguration) {
        return new RepositoryManager(mApplication, retrofit, rxCache, cacheFactory, roomConfiguration);
    }

    @Singleton
    @Provides
    Cache<String, Object> provideExtras(Cache.Factory cacheFactory) {
        return cacheFactory.build(CacheType.EXTRAS_CACHE_TYPE);
    }
}
