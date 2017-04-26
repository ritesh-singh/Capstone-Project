package com.example.riteshkumarsingh.capstone_stage2.ui.detail.presenter;

import com.example.riteshkumarsingh.capstone_stage2.core.BasePresenter;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.view.DetailView;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

@FragmentScope
public class DetailFragmentPresenter extends BasePresenter {

    private GetMovieDetails getMovieDetails;
    private GetMovieVideos getMovieVideos;

    private DetailView mDetailView;

    private Subscription mMovieDetailSubscription;
    private Subscription mMovieVideoSubscription;

    @Inject
    public DetailFragmentPresenter(GetMovieDetails getMovieDetails,
                                   GetMovieVideos getMovieVideos){
        super();
        this.getMovieDetails = getMovieDetails;
        this.getMovieVideos = getMovieVideos;
    }

    public void setDetailView(DetailView detailView){
        this.mDetailView = detailView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        super.stop();
    }

    public void fetchMovieDetailsFromRepo(Long movie_id){
        RxUtils.unSubscribe(mMovieDetailSubscription);
        mDetailView.showProgressBar();
        mMovieDetailSubscription = getMovieDetails
                .getMovieDetails(movie_id)
                .compose(RxUtils.applyIOScheduler())
                .subscribe(movieDetails -> {
                    mDetailView.hideProgressBar();
                    mDetailView.onMovieDetailResponse(movieDetails);
                }, throwable -> {
                    mDetailView.hideProgressBar();
                    mDetailView.showError(throwable.getMessage());
                });
        mCompositeSubscription.add(mMovieDetailSubscription);
    }

    private void fetchMovieVideosFromRepo(Long movie_id){
        RxUtils.unSubscribe(mMovieVideoSubscription);
        mDetailView.showProgressBar();
        getMovieVideos
                .getMovieVideos(movie_id)
                .compose(RxUtils.applyIOScheduler())
                .subscribe(movieVideos -> {
                    mDetailView.hideProgressBar();
                    mDetailView.onMovieVideoResponse(movieVideos);
                }, throwable -> {
                    mDetailView.hideProgressBar();
                    mDetailView.showError(throwable.getMessage());
                });
        mCompositeSubscription.add(mMovieVideoSubscription);
    }

}
