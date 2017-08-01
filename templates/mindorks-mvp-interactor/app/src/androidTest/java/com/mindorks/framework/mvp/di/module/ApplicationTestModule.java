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

package <%= appPackage %>.di.module;

import android.app.Application;
import android.content.Context;

import <%= appPackage %>.BuildConfig;
import <%= appPackage %>.R;
import <%= appPackage %>.data.db.DbOpenHelper;
import <%= appPackage %>.data.db.model.DaoMaster;
import <%= appPackage %>.data.db.model.DaoSession;
import <%= appPackage %>.data.network.ApiHeader;
import <%= appPackage %>.data.network.ApiHelper;
import <%= appPackage %>.data.network.AppApiHelper;
import <%= appPackage %>.data.prefs.AppPreferencesHelper;
import <%= appPackage %>.data.prefs.PreferencesHelper;
import <%= appPackage %>.di.ApiInfo;
import <%= appPackage %>.di.ApplicationContext;
import <%= appPackage %>.di.DatabaseInfo;
import <%= appPackage %>.di.PreferenceInfo;
import <%= appPackage %>.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by janisharali on 21/07/17.
 */
@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    // TODO : Mock all below for UI testing

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(
            @ApiInfo String apiKey,
            PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DbOpenHelper dbOpenHelper) {
        return new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }
}
