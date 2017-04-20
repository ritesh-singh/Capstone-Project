package com.example.riteshkumarsingh.capstone_stage2.di;

import android.app.Application;
import android.content.Context;

import com.example.riteshkumarsingh.capstone_stage2.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

@Module
public class ApplicationModule {
    Application mApplication;
    Context mContext;

    public ApplicationModule(Application application){
        mApplication = application;
        mContext = application.getApplicationContext();
    }

    @Provides
    @ApplicationScope
    Application providesApplication(){
        return mApplication;
    }

    @Provides
    @ApplicationScope
    Context providesContext(){
        return mContext;
    }
}
