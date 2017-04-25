package com.example.riteshkumarsingh.capstone_stage2.core;


import com.example.riteshkumarsingh.capstone_stage2.bus.RxBus;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import java.util.Map;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

public abstract class BasePresenter implements BasePresenterInterface{

    protected CompositeSubscription mCompositeSubscription;
    protected RxBus mRxBus;
    protected Subscription mRxBusSubscription;

    public BasePresenter(){
        mCompositeSubscription  = new CompositeSubscription();
        mRxBus = RxBus.getInstance();
    }

    @Override
    public void stop() {
        RxUtils.clear(mCompositeSubscription);
        RxUtils.unSubscribe(mRxBusSubscription);
    }
}
