package com.example.riteshkumarsingh.capstone_stage2.di;

import com.example.riteshkumarsingh.capstone_stage2.data.source.remote.ApiService;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.ApplicationScope;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by riteshkumarsingh on 17/04/17.
 */

@Module
public class NetworkModule {
    String mBaseUrl;

    public NetworkModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addNetworkInterceptor(new StethoInterceptor()).build())
                .baseUrl(mBaseUrl)
                .build();
    }

    @Provides
    @ApplicationScope
    public ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    @ApplicationScope
    public DatabaseReference providesDataBaseReference(){
        return FirebaseDatabase.getInstance().getReference();
    }
}
