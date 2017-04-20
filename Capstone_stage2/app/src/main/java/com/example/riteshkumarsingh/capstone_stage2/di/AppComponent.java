package com.example.riteshkumarsingh.capstone_stage2.di;

import android.content.SharedPreferences;

import com.example.riteshkumarsingh.capstone_stage2.data.source.remote.ApiService;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ApplicationScope;
import com.example.riteshkumarsingh.capstone_stage2.storage.SharedPreferenceManager;

import dagger.Component;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class,DataModule.class,NetworkModule.class})
public interface AppComponent {
    ApiService getMovieApiService();

    SharedPreferenceManager getSharedPrefManager();

}
