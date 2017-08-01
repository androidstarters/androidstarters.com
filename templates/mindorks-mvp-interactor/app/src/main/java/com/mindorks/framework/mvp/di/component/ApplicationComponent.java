/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package <%= appPackage %>.di.component;

import android.app.Application;
import android.content.Context;

import <%= appPackage %>.MvpApp;
import <%= appPackage %>.data.db.model.DaoSession;
import <%= appPackage %>.data.network.ApiHelper;
import <%= appPackage %>.data.prefs.PreferencesHelper;
import <%= appPackage %>.di.ApplicationContext;
import <%= appPackage %>.di.module.ApplicationModule;
import <%= appPackage %>.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    PreferencesHelper preferencesHelper();

    ApiHelper apiHelper();

    DaoSession daoSession();
}