package com.example.riteshkumarsingh.capstone_stage2.ui.detail.view;

import com.example.riteshkumarsingh.capstone_stage2.core.BaseView;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

public interface DetailView extends BaseView{
    void onMovieDetailResponse(MovieDetails movieDetails);
    void onMovieVideoResponse(MovieVideos movieVideos);
}
