package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments;

import com.example.riteshkumarsingh.capstone_stage2.core.BaseView;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public interface MovieView extends BaseView{
    void showResult(Movies movies);
    void onMovieItemClick(Long movie_id);
}
