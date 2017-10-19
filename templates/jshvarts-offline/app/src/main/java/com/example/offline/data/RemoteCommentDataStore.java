package <%= appPackage %>.data;

import <%= appPackage %>.domain.RemoteCommentRepository;
import <%= appPackage %>.domain.services.jobs.JobManagerFactory;
import <%= appPackage %>.domain.services.jobs.SyncCommentJob;
import <%= appPackage %>.model.Comment;

import io.reactivex.Completable;

public class RemoteCommentDataStore implements RemoteCommentRepository {

    @Override
    public Completable sync(Comment comment) {
        return Completable.fromAction(() ->
                JobManagerFactory.getJobManager().addJobInBackground(new SyncCommentJob(comment)));
    }
}
