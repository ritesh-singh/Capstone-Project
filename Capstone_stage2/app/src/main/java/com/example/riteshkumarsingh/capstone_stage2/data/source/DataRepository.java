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

    private DataSource mRemoteDataSource;
    private DataSource mFireBaseDataSource;

    private boolean isFromRemote = false;

    @Inject
    public DataRepository(@NonNull RemoteDataSource remoteDataSource,
                          @NonNull FireBaseDataSource firebaseDataSource) {
        this.mRemoteDataSource = remoteDataSource;
        this.mFireBaseDataSource = firebaseDataSource;
    }

    public void setIsFromRemote(boolean isFromCache){
        this.isFromRemote = isFromCache;
    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String, String> options) {
        if (isFromRemote){
            return mRemoteDataSource.getPopularMovies(options);
        }
        return mFireBaseDataSource.getPopularMovies(options);
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String, String> options) {
        if (isFromRemote){
            return mRemoteDataSource.getTopRatedMovies(options);
        }
        return mFireBaseDataSource.getTopRatedMovies(options);
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String, String> options) {
        if (isFromRemote){
            return mRemoteDataSource.getNowPlayingMovies(options);
        }
        return mFireBaseDataSource.getNowPlayingMovies(options);
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String, String> options) {
        if (isFromRemote){
            return mRemoteDataSource.getUpComingMovies(options);
        }
        return mFireBaseDataSource.getUpComingMovies(options);
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String, String> options) {
        if (isFromRemote){
            return mRemoteDataSource.getLatestMovies(options);
        }
        return mFireBaseDataSource.getLatestMovies(options);
    }

    @Override
    public Observable<MovieDetails> getMovieDetails(Long movie_id) {
        if (isFromRemote){
            return mRemoteDataSource.getMovieDetails(movie_id);
        }
        return mFireBaseDataSource.getMovieDetails(movie_id);
    }

    @Override
    public Observable<MovieVideos> getMovieVideos(Long movie_id) {
        if (isFromRemote){
            return mRemoteDataSource.getMovieVideos(movie_id);
        }
        return mFireBaseDataSource.getMovieVideos(movie_id);
    }
}
