package com.example.riteshkumarsingh.capstone_stage2.ui.detail.presenter;

import com.example.riteshkumarsingh.capstone_stage2.core.BasePresenter;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.view.DetailView;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import javax.inject.Inject;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

@FragmentScope
public class DetailFragmentPresenter extends BasePresenter {

    private GetMovieDetails getMovieDetails;
    private GetMovieVideos getMovieVideos;

    private DetailView mDetailView;

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

    private void fetchMovieDetailsFromRepo(Long movie_id){
        mCompositeSubscription.add(getMovieDetails
        .getMovieDetails(movie_id)
        .compose(RxUtils.applyIOScheduler())
        .subscribe(movieDetails -> {
            mDetailView.onMovieDetailResponse(movieDetails);
        },throwable -> {
            mDetailView.showError(throwable.getMessage());
        }));
    }

    private void fetchMovieVideosFromRepo(Long movie_id){
        mCompositeSubscription.add(getMovieVideos
        .getMovieVideos(movie_id)
        .compose(RxUtils.applyIOScheduler())
        .subscribe(movieVideos -> {
            mDetailView.onMovieVideoResponse(movieVideos);
        },throwable -> {
            mDetailView.showError(throwable.getMessage());
        }));
    }

}
