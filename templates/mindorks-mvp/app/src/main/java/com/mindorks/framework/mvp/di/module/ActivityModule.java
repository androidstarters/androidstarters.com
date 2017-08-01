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

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import <%= appPackage %>.data.network.model.BlogResponse;
import <%= appPackage %>.data.network.model.OpenSourceResponse;
import <%= appPackage %>.di.ActivityContext;
import <%= appPackage %>.di.PerActivity;
import <%= appPackage %>.ui.about.AboutMvpPresenter;
import <%= appPackage %>.ui.about.AboutMvpView;
import <%= appPackage %>.ui.about.AboutPresenter;
import <%= appPackage %>.ui.feed.FeedMvpPresenter;
import <%= appPackage %>.ui.feed.FeedMvpView;
import <%= appPackage %>.ui.feed.FeedPagerAdapter;
import <%= appPackage %>.ui.feed.FeedPresenter;
import <%= appPackage %>.ui.feed.blogs.BlogAdapter;
import <%= appPackage %>.ui.feed.blogs.BlogMvpPresenter;
import <%= appPackage %>.ui.feed.blogs.BlogMvpView;
import <%= appPackage %>.ui.feed.blogs.BlogPresenter;
import <%= appPackage %>.ui.feed.opensource.OpenSourceAdapter;
import <%= appPackage %>.ui.feed.opensource.OpenSourceMvpPresenter;
import <%= appPackage %>.ui.feed.opensource.OpenSourceMvpView;
import <%= appPackage %>.ui.feed.opensource.OpenSourcePresenter;
import <%= appPackage %>.ui.login.LoginMvpPresenter;
import <%= appPackage %>.ui.login.LoginMvpView;
import <%= appPackage %>.ui.login.LoginPresenter;
import <%= appPackage %>.ui.main.MainMvpPresenter;
import <%= appPackage %>.ui.main.MainMvpView;
import <%= appPackage %>.ui.main.MainPresenter;
import <%= appPackage %>.ui.main.rating.RatingDialogMvpPresenter;
import <%= appPackage %>.ui.main.rating.RatingDialogMvpView;
import <%= appPackage %>.ui.main.rating.RatingDialogPresenter;
import <%= appPackage %>.ui.splash.SplashMvpPresenter;
import <%= appPackage %>.ui.splash.SplashMvpView;
import <%= appPackage %>.ui.splash.SplashPresenter;
import <%= appPackage %>.utils.rx.AppSchedulerProvider;
import <%= appPackage %>.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
