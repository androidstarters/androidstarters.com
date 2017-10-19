package <%= appPackage %>.domain.services;

import <%= appPackage %>.model.Comment;
import com.jakewharton.rxrelay2.PublishRelay;

import io.reactivex.Observable;

public class SyncCommentRxBus {

    private static SyncCommentRxBus instance;
    private final PublishRelay<SyncCommentResponse> relay;

    public static synchronized SyncCommentRxBus getInstance() {
        if (instance == null) {
            instance = new SyncCommentRxBus();
        }
        return instance;
    }

    private SyncCommentRxBus() {
        relay = PublishRelay.create();
    }

    public void post(SyncResponseEventType eventType, Comment comment) {
        relay.accept(new SyncCommentResponse(eventType, comment));
    }

    public Observable<SyncCommentResponse> toObservable() {
        return relay;
    }
}
