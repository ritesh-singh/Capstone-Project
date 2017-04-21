package com.example.riteshkumarsingh.capstone_stage2.ui.home.presenter;

import com.example.riteshkumarsingh.capstone_stage2.core.BasePresenter;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.MovieView;

import java.util.Map;

/**
 * Created by riteshkumarsingh on 21/04/17.
 */

public abstract class MoviesBasePresenter extends BasePresenter {
    protected MovieView mMovieView;

    MoviesBasePresenter() {
        super();
    }

    public void setMoviePopularView(MovieView movieView) {
        mMovieView = movieView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        super.stop();
    }

    protected abstract void fetchMovies(final Map<String,String> options);
}
