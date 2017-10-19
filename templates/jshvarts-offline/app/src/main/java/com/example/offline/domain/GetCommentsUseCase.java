package <%= appPackage %>.domain;

import <%= appPackage %>.model.Comment;
import <%= appPackage %>.model.ModelConstants;

import java.util.List;

import io.reactivex.Flowable;

public class GetCommentsUseCase {
    private final LocalCommentRepository localCommentRepository;

    public GetCommentsUseCase(LocalCommentRepository localCommentRepository) {
        this.localCommentRepository = localCommentRepository;
    }

    public Flowable<List<Comment>> getComments() {
        return localCommentRepository.getComments(ModelConstants.DUMMY_PHOTO_ID);
    }
}
