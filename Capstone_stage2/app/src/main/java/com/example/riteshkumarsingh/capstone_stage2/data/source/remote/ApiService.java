package com.example.riteshkumarsingh.capstone_stage2.data.source.remote;

import com.example.riteshkumarsingh.capstone_stage2.data.models.configuration.Configuration;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

public interface ApiService {

    @GET("configuration")
    Observable<Configuration> getConfiguration();

    @GET("movie/popular")
    Observable<Movies> getPopularMovies(@QueryMap Map<String, String> options);

    @GET("movie/top_rated")
    Observable<Movies> getTopRatedMovies(@QueryMap Map<String, String> options);

    @GET("movie/now_playing")
    Observable<Movies> getNowPlayingMovies(@QueryMap Map<String, String> options);

    @GET("movie/upcoming")
    Observable<Movies> getUpComingMovies(@QueryMap Map<String, String> options);

    @GET("movie/latest")
    Observable<Movies> getLatestMovies(@QueryMap Map<String, String> options);

}
