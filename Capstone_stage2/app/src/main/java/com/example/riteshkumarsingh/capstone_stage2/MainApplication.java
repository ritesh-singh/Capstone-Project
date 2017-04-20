package com.example.riteshkumarsingh.capstone_stage2;

import android.app.Application;

import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.di.AppComponent;
import com.example.riteshkumarsingh.capstone_stage2.di.ApplicationModule;
import com.example.riteshkumarsingh.capstone_stage2.di.DaggerAppComponent;
import com.example.riteshkumarsingh.capstone_stage2.di.DataModule;
import com.example.riteshkumarsingh.capstone_stage2.di.NetworkModule;
import com.facebook.stetho.Stetho;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

public class MainApplication extends Application {

    private AppComponent mAppComponent;

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDependencyInjector();

        if (BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this);
        }
    }


    private void initializeDependencyInjector(){
        mAppComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .networkModule(new NetworkModule(Constants.SERVICE_END_POINT))
                .build();
    }

}
