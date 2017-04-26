package com.example.riteshkumarsingh.capstone_stage2.domain.usecase;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataRepository;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

@FragmentScope
public class GetMovieVideos {
    private DataRepository mDataRepository;

    @Inject
    public GetMovieVideos(DataRepository dataRepository) {
        mDataRepository = dataRepository;
    }

    public Observable<MovieVideos> getMovieVideos(Long movie_id) {
        return mDataRepository.getMovieVideos(movie_id);
    }
}
