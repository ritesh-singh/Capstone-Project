package com.example.riteshkumarsingh.capstone_stage2.data.source;


import android.support.annotation.NonNull;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.firebase.FireBaseDataSource;
import com.example.riteshkumarsingh.capstone_stage2.data.source.remote.RemoteDataSource;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */


@FragmentScope
public class DataRepository implements DataSource{

    private DataSource mDataSource;

    @Inject
    public DataRepository(@NonNull RemoteDataSource remoteDataSource,
                          @NonNull FireBaseDataSource firebaseDataSource,
                          @NonNull Boolean isNetworkActive) {
        if (isNetworkActive) {
            this.mDataSource = remoteDataSource;
        } else {
            this.mDataSource = firebaseDataSource;
        }
    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String, String> options) {
        return mDataSource.getPopularMovies(options);
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String, String> options) {
        return mDataSource.getTopRatedMovies(options);
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String, String> options) {
        return mDataSource.getNowPlayingMovies(options);
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String, String> options) {
        return mDataSource.getUpComingMovies(options);
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String, String> options) {
        return mDataSource.getLatestMovies(options);
    }

    @Override
    public Observable<MovieDetails> getMovieDetails(Long movie_id) {
        return mDataSource.getMovieDetails(movie_id);
    }

    @Override
    public Observable<MovieVideos> getMovieVideos(Long movie_id) {
        return mDataSource.getMovieVideos(movie_id);
    }
}
