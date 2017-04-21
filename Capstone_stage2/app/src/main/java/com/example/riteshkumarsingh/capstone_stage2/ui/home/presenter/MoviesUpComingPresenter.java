package com.example.riteshkumarsingh.capstone_stage2.ui.home.presenter;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetUpComingMovies;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by riteshkumarsingh on 19/04/17.
 */

public class MoviesUpComingPresenter extends MoviesBasePresenter{
    private GetUpComingMovies getUpComingMovies;

    @Inject
    public MoviesUpComingPresenter(GetUpComingMovies getUpComingMovies) {
        super();
        this.getUpComingMovies = getUpComingMovies;
    }


    @Override
    public void fetchMovies(Map<String, String> options) {
        mMovieView.showProgressBar();
        getUpComingMovies
                .getMovies(options)
                .compose(RxUtils.applyIOScheduler())
                .subscribe(new Action1<Movies>() {
                    @Override
                    public void call(Movies movies) {
                        mMovieView.hideProgressBar();
                        mMovieView.showResult(movies);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mMovieView.hideProgressBar();
                        mMovieView.showError();
                    }
                });
    }
}
