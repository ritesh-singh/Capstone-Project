package com.example.riteshkumarsingh.capstone_stage2.data.source;


import android.content.Context;
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

    private DataSource mRemoteDataSource;
    private DataSource mFireBaseDataSource;

    private boolean isFromCache = false;

    @Inject
    public DataRepository(@NonNull RemoteDataSource remoteDataSource,
                          @NonNull FireBaseDataSource firebaseDataSource) {
        this.mRemoteDataSource = remoteDataSource;
        this.mFireBaseDataSource = firebaseDataSource;
    }

    public void setIsFromCache(boolean isFromCache){
        this.isFromCache = isFromCache;
    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String, String> options) {
        if (isFromCache){
            return mFireBaseDataSource.getPopularMovies(options);
        }
        return mRemoteDataSource.getPopularMovies(options);
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String, String> options) {
        if (isFromCache){
            return mFireBaseDataSource.getTopRatedMovies(options);
        }
        return mRemoteDataSource.getTopRatedMovies(options);
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String, String> options) {
        if (isFromCache){
            return mFireBaseDataSource.getNowPlayingMovies(options);
        }
        return mRemoteDataSource.getNowPlayingMovies(options);
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String, String> options) {
        if (isFromCache){
            return mFireBaseDataSource.getUpComingMovies(options);
        }
        return mRemoteDataSource.getUpComingMovies(options);
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String, String> options) {
        if (isFromCache){
            return mFireBaseDataSource.getLatestMovies(options);
        }
        return mRemoteDataSource.getLatestMovies(options);
    }

    @Override
    public Observable<MovieDetails> getMovieDetails(Long movie_id) {
        if (isFromCache){
            return mFireBaseDataSource.getMovieDetails(movie_id);
        }
        return mRemoteDataSource.getMovieDetails(movie_id);
    }

    @Override
    public Observable<MovieVideos> getMovieVideos(Long movie_id) {
        if (isFromCache){
            return mFireBaseDataSource.getMovieVideos(movie_id);
        }
        return mRemoteDataSource.getMovieVideos(movie_id);
    }
}
