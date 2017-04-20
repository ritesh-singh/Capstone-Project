package com.example.riteshkumarsingh.capstone_stage2.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ApplicationScope;
import com.example.riteshkumarsingh.capstone_stage2.storage.SharedPreferenceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

@Module
public class DataModule {

    @Provides
    @ApplicationScope
    SharedPreferences providesSharedPreference(Application application) {
        return application.getSharedPreferences(Constants.SHARED_PREF_FILENAME, Context.MODE_PRIVATE);
    }


    @Provides
    @ApplicationScope
    SharedPreferenceManager providesSharedPreferenceManager(SharedPreferences sharedPreferences) {
        return new SharedPreferenceManager(sharedPreferences);
    }
}
