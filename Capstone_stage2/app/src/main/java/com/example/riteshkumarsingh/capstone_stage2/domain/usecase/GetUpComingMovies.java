package com.example.riteshkumarsingh.capstone_stage2.domain.usecase;

import android.support.annotation.NonNull;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataRepository;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ActivityScope;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

@FragmentScope
public class GetUpComingMovies extends MovieUseCaseBasic {

    @Inject
    public GetUpComingMovies(@NonNull DataRepository dataRepository){
        this.mDataRepository = dataRepository;
    }

    @Override
    public Observable<Movies> getMovies(Map<String, String> options) {
        return mDataRepository.getUpComingMovies(options);
    }
}
