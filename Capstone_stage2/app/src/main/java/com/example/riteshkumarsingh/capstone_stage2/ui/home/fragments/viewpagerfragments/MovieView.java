package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public interface MovieView {
    void showProgressBar();
    void hideProgressBar();
    void showResult(Movies movies);
    void showError();
    void onMovieItemClick(Long movie_id);
}
