package com.example.riteshkumarsingh.capstone_stage2.ui.home.presenter;

import com.example.riteshkumarsingh.capstone_stage2.core.BasePresenter;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviePopularView;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesPopularFragment;

import javax.inject.Inject;

/**
 * Created by riteshkumarsingh on 19/04/17.
 */

@FragmentScope
public class MoviesPopularPresenter implements BasePresenter {

    private MoviePopularView mMoviePopularView;

    @Inject
    public MoviesPopularPresenter(){

    }

    public void setMoviePopularView(MoviesPopularFragment moviePopularView){
        mMoviePopularView = moviePopularView;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
