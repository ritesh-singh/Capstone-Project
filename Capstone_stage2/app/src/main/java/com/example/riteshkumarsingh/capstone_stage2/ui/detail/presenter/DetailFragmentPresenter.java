package com.example.riteshkumarsingh.capstone_stage2.ui.detail.presenter;

import com.example.riteshkumarsingh.capstone_stage2.core.BasePresenter;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.view.DetailView;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

@FragmentScope
public class DetailFragmentPresenter extends BasePresenter {

    private GetMovieDetails getMovieDetails;
    private GetMovieVideos getMovieVideos;

    private DetailView mDetailView;

    private Subscription mMovieAndVideoSubscription;

    @Inject
    public DetailFragmentPresenter(GetMovieDetails getMovieDetails,
                                   GetMovieVideos getMovieVideos) {
        super();
        this.getMovieDetails = getMovieDetails;
        this.getMovieVideos = getMovieVideos;
    }

    public void setDetailView(DetailView detailView) {
        this.mDetailView = detailView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        super.stop();
        RxUtils.unSubscribe(mMovieAndVideoSubscription);
    }


    public void fetchMovieDetailsAndVideos(Long movied_id) {
        mDetailView.showProgressBar();
        RxUtils.unSubscribe(mMovieAndVideoSubscription);

        getMovieDetails.setIsFromRemote(mDetailView.isNetworkActive());
        getMovieVideos.setIsFromRemote(mDetailView.isNetworkActive());

        Observable<MovieDetails> movieDetailsObservable =
                getMovieDetails
                        .getMovieDetails(movied_id)
                        .compose(RxUtils.applyIOScheduler());

        Observable<MovieVideos> movieVideosObservable =
                getMovieVideos
                        .getMovieVideos(movied_id)
                        .compose(RxUtils.applyIOScheduler());

        Observable<MovieAndVideo> movieAndVideoCombinedObservable =
                Observable.zip(movieDetailsObservable, movieVideosObservable,
                        new Func2<MovieDetails, MovieVideos, MovieAndVideo>() {
                            @Override
                            public MovieAndVideo call(MovieDetails movieDetails, MovieVideos movieVideos) {
                                return new MovieAndVideo(movieDetails,
                                        movieVideos);
                            }
                        });

        mMovieAndVideoSubscription = movieAndVideoCombinedObservable
                .subscribe(movieAndVideo -> {
                    mDetailView.hideProgressBar();
                    mDetailView.onMovieAndVideoResponse(movieAndVideo);
                },throwable -> {
                    mDetailView.hideProgressBar();
                    mDetailView.showError(throwable.getMessage());
                });

    }

    public void onPlayButtonClick(String key){
        mDetailView.launchYouTubeVideo(key);
    }

    public class MovieAndVideo {

        public MovieDetails movieDetails;
        public MovieVideos movieVideos;

        public MovieAndVideo(MovieDetails movieDetails,
                             MovieVideos movieVideos) {
            this.movieDetails = movieDetails;
            this.movieVideos = movieVideos;
        }

    }

}
