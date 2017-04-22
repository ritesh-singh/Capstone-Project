package com.example.riteshkumarsingh.capstone_stage2;

import com.example.riteshkumarsingh.capstone_stage2.di.AppComponent;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesPopularFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesTopRatedFragment;

import dagger.Component;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

@FragmentScope
@Component(dependencies = {AppComponent.class})
public interface BasicUseCaseComponents {
    void inject(MoviesPopularFragment moviesPopularFragment);
    void inject(MoviesTopRatedFragment moviesTopRatedFragment);
}
