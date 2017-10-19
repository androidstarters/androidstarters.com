package <%= appPackage %>.di;

import android.content.Context;

import <%= appPackage %>.App;
import <%= appPackage %>.data.CommentDao;
import <%= appPackage %>.data.CommentDatabase;
import <%= appPackage %>.data.LocalCommentDataStore;
import <%= appPackage %>.data.RemoteCommentDataStore;
import <%= appPackage %>.domain.LocalCommentRepository;
import <%= appPackage %>.domain.RemoteCommentRepository;
import <%= appPackage %>.domain.services.jobs.GcmJobService;
import <%= appPackage %>.domain.services.jobs.SchedulerJobService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    SchedulerJobService provideSchedulerJobService() {
        return new SchedulerJobService();
    }

    @Singleton
    @Provides
    GcmJobService provideGcmJobService() {
        return new GcmJobService();
    }

    @Singleton
    @Provides
    CommentDao provideCommentDao(Context context) {
        return CommentDatabase.getInstance(context).commentDao();
    }

    @Singleton
    @Provides
    LocalCommentRepository provideLocalCommentRepository(CommentDao commentDao) {
        return new LocalCommentDataStore(commentDao);
    }

    @Singleton
    @Provides
    RemoteCommentRepository provideRemoteCommentRepository() {
        return new RemoteCommentDataStore();
    }
}
