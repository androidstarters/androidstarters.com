package <%= appPackage %>.domain;

import <%= appPackage %>.model.Comment;

import io.reactivex.Completable;

public interface RemoteCommentRepository {
    Completable sync(Comment comment);
}
