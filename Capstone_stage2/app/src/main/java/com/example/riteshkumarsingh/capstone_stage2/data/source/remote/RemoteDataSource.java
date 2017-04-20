package com.example.riteshkumarsingh.capstone_stage2.data.source.remote;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataSource;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ActivityScope;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

@ActivityScope
public class RemoteDataSource implements DataSource{

    private ApiService mApiService;

    @Inject
    public RemoteDataSource(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String,String> options) {
        return mApiService.getPopularMovies(options);
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String,String> options) {
        return mApiService.getTopRatedMovies(options);
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String,String> options) {
        return mApiService.getNowPlayingMovies(options);
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String,String> options) {
        return mApiService.getUpComingMovies(options);
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String,String> options) {
        return mApiService.getLatestMovies(options);
    }
}
