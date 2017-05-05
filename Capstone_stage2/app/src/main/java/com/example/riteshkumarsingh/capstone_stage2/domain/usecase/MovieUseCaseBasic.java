package com.example.riteshkumarsingh.capstone_stage2.domain.usecase;

import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataRepository;

import java.util.Map;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public abstract class MovieUseCaseBasic extends UseCaseBasic{

    abstract Observable<Movies> getMovies(Map<String,String> options);

}
