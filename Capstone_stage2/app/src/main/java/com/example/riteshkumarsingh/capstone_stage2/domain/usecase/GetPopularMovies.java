package com.example.riteshkumarsingh.capstone_stage2.domain.usecase;

import android.support.annotation.NonNull;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataRepository;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 19/04/17.
 */

@FragmentScope
public class GetPopularMovies extends MovieUseCaseBasic {

    @Inject
    public GetPopularMovies(@NonNull DataRepository dataRepository) {
        this.mDataRepository = dataRepository;
    }

    @Override
    public Observable<Movies> getMovies(Map<String, String> options) {
        return mDataRepository.getPopularMovies(options);
    }

    @Override
    public void setIsFromRemote(boolean isFromRemote) {
        mDataRepository.setIsFromRemote(isFromRemote);
    }
}
