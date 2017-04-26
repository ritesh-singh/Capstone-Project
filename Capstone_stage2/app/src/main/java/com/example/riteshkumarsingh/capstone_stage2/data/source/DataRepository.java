package com.example.riteshkumarsingh.capstone_stage2.data.source;

import android.support.annotation.NonNull;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.firebase.FireBaseDataSource;
import com.example.riteshkumarsingh.capstone_stage2.data.source.remote.RemoteDataSource;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ActivityScope;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */


// TODO - Add a flag or something to determine, the firebase source or remote source.

@FragmentScope
public class DataRepository implements DataSource{

    private DataSource mRemoteDataSource;
    private DataSource mFireBaseDataSource;

    @Inject
    public DataRepository(@NonNull RemoteDataSource remoteDataSource,
                          @NonNull FireBaseDataSource firebaseDataSource) {
        this.mRemoteDataSource = remoteDataSource;
        this.mFireBaseDataSource = firebaseDataSource;
    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String, String> options) {
        return mRemoteDataSource.getPopularMovies(options);
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String, String> options) {
        return mRemoteDataSource.getTopRatedMovies(options);
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String, String> options) {
        return mRemoteDataSource.getNowPlayingMovies(options);
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String, String> options) {
        return mRemoteDataSource.getUpComingMovies(options);
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String, String> options) {
        return mRemoteDataSource.getLatestMovies(options);
    }

    @Override
    public Observable<MovieDetails> getMovieDetails(Long movie_id) {
        return mRemoteDataSource.getMovieDetails(movie_id);
    }

    @Override
    public Observable<MovieVideos> getMovieVideos(Long movie_id) {
        return mRemoteDataSource.getMovieVideos(movie_id);
    }
}
