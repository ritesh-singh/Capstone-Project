package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public interface MoviePopularView {
    void showProgressBar();
    void hideProgressBar();
    void showResult(Movies movies);
    void showError();
}
