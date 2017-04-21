package com.example.riteshkumarsingh.capstone_stage2.core;

import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

public abstract class BasePresenter implements BasePresenterInterface{

    protected CompositeSubscription mCompositeSubscription;

    public BasePresenter(){
        mCompositeSubscription  = new CompositeSubscription();
    }

    @Override
    public void stop() {
        RxUtils.clear(mCompositeSubscription);
    }
}
