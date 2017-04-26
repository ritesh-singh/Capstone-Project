package com.example.riteshkumarsingh.capstone_stage2.data.source;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;

import java.util.Map;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

public interface DataSource {
    Observable<Movies> getPopularMovies(Map<String,String> options);
    Observable<Movies> getTopRatedMovies(Map<String,String> options);
    Observable<Movies> getNowPlayingMovies(Map<String,String> options);
    Observable<Movies> getUpComingMovies(Map<String,String> options);
    Observable<Movies> getLatestMovies(Map<String,String> options);
    Observable<MovieDetails> getMovieDetails(Long movie_id);
    Observable<MovieVideos> getMovieVideos(Long movie_id);
}
