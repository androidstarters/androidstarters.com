package <%= appPackage %>.domain.services;

import <%= appPackage %>.model.Comment;

public class SyncCommentResponse {
    public final SyncResponseEventType eventType;
    public final Comment comment;

    public SyncCommentResponse(SyncResponseEventType eventType, Comment comment) {
        this.eventType = eventType;
        this.comment = comment;
    }
}
