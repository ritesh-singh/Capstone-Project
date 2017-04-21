package com.example.riteshkumarsingh.capstone_stage2.ui.home.presenter;

import com.example.riteshkumarsingh.capstone_stage2.core.BasePresenter;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetPopularMovies;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviePopularView;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesPopularFragment;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by riteshkumarsingh on 19/04/17.
 */

@FragmentScope
public class MoviesPopularPresenter extends BasePresenter {

    private MoviePopularView mMoviePopularView;

    private GetPopularMovies getPopularMovies;

    @Inject
    public MoviesPopularPresenter(GetPopularMovies getPopularMovies){
        super();
        this.getPopularMovies = getPopularMovies;
    }

    public void setMoviePopularView(MoviesPopularFragment moviePopularView){
        mMoviePopularView = moviePopularView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        super.stop();
    }

    public void fetchPopularMovies(Map<String, String> options) {
        mMoviePopularView.showProgressBar();
        getPopularMovies
                .getMovies(options)
                .compose(RxUtils.applyIOScheduler())
                .subscribe(new Action1<Movies>() {
                    @Override
                    public void call(Movies movies) {
                        mMoviePopularView.hideProgressBar();
                        mMoviePopularView.showResult(movies);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mMoviePopularView.hideProgressBar();
                        mMoviePopularView.showError();
                    }
                });
    }
}
