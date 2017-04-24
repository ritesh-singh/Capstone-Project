package com.example.riteshkumarsingh.capstone_stage2.data.source.firebase;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataSource;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

@FragmentScope
public class FireBaseDataSource implements DataSource {

    @Inject
    public FireBaseDataSource(){

    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String, String> options) {
        return null;
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String, String> options) {
        return null;
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String, String> options) {
        return null;
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String, String> options) {
        return null;
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String, String> options) {
        return null;
    }

    @Override
    public Observable<MovieDetails> getMovieDetails(int movie_id) {
        return null;
    }

    @Override
    public Observable<MovieVideos> getMovieVideos(int movie_id) {
        return null;
    }
}
