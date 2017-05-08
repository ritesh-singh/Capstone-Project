package com.example.riteshkumarsingh.capstone_stage2.domain.usecase;

import android.support.annotation.NonNull;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataRepository;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;


import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

@FragmentScope
public class GetMovieDetails extends UseCaseBasic {

    @Inject
    public GetMovieDetails(@NonNull DataRepository dataRepository) {
        mDataRepository = dataRepository;
    }

    public Observable<MovieDetails> getMovieDetails(Long movie_id) {
        return mDataRepository.getMovieDetails(movie_id);
    }

    @Override
    public void setIsFromRemote(boolean isFromCache) {
        mDataRepository.setIsFromRemote(isFromCache);
    }
}
