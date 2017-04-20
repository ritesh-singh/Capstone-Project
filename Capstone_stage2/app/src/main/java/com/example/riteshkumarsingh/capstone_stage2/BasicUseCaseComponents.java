package com.example.riteshkumarsingh.capstone_stage2;

import com.example.riteshkumarsingh.capstone_stage2.di.AppComponent;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface BasicUseCaseComponents {
}
