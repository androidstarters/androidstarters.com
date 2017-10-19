package <%= appPackage %>.repository.di.component;

import java.io.File;

import javax.inject.Singleton;

import dagger.Component;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import <%= appPackage %>.repository.IRepositoryManager;
import <%= appPackage %>.repository.RepositoryInjector;
import <%= appPackage %>.repository.cache.Cache;
import <%= appPackage %>.repository.di.module.ClientModule;
import <%= appPackage %>.repository.di.module.RepositoryConfigModule;
import <%= appPackage %>.repository.di.module.RepositoryModule;
import okhttp3.OkHttpClient;

/**
 * Created by xiaobailong24 on 2017/9/28.
 * Dagger RepositoryComponent
 */
@Singleton
@Component(modules = {RepositoryModule.class, ClientModule.class, RepositoryConfigModule.class})
public interface RepositoryComponent {
    //用于管理网络请求层和数据库层
    IRepositoryManager repositoryManager();

    //Rxjava 错误处理管理类
    RxErrorHandler rxErrorHandler();

    //提供 OKHttpClient
    OkHttpClient okHttpClient();

    //提供缓存文件
    File cacheFile();

    //为外部使用提供Cache,切勿大量存放大容量数据
    Cache<String, Object> extras();

    void inject(RepositoryInjector repositoryInjector);
}
