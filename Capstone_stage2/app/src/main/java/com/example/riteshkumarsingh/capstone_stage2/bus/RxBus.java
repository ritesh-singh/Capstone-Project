package com.example.riteshkumarsingh.capstone_stage2.bus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

public class RxBus {
    private static RxBus instance;

    private final Subject<Object, Object> subject = new SerializedSubject<>(PublishSubject.create());

    private RxBus() {
    }

    static {
        try {
            instance = new RxBus();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured while creating RxBus singleton instance");
        }
    }

    public static RxBus getInstance() {
        return instance;
    }

    public void send(Object object) {
        subject.onNext(object);
    }

    public Observable<Object> toObserverable() {
        return subject;
    }
}
