package com.example.riteshkumarsingh.capstone_stage2.data.sync;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

import com.example.riteshkumarsingh.capstone_stage2.BasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.DaggerBasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.MainApplication;
import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetMovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetNowPlayingMovies;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetPopularMovies;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetTopRatedMovies;
import com.example.riteshkumarsingh.capstone_stage2.domain.usecase.GetUpComingMovies;
import com.example.riteshkumarsingh.capstone_stage2.utils.RxUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by riteshkumarsingh on 04/05/17.
 */
public class JobSchedulerService extends JobService {

    @Inject
    GetPopularMovies getPopularMovies;

    @Inject
    GetTopRatedMovies getTopRatedMovies;

    @Inject
    GetNowPlayingMovies getNowPlayingMovies;

    @Inject
    GetUpComingMovies getUpComingMovies;

    @Inject
    GetMovieDetails getMovieDetails;

    @Inject
    GetMovieVideos getMovieVideos;

    @Inject
    DatabaseReference mDatabaseReference;

    private BasicUseCaseComponents mBasicUseCaseComponents;

    private Subscription mSubscription;
    private CompositeSubscription mCompositeSubscription;


    private DatabaseReference.CompletionListener mCompletionListener;

    private void initDagger(){
        mBasicUseCaseComponents = DaggerBasicUseCaseComponents.builder()
                .appComponent(((MainApplication) getApplication()).getAppComponent())
                .build();

        mBasicUseCaseComponents.add(this);
    }

    private void initFireBase() {
        mCompletionListener = new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                Log.d(JobSchedulerService.class.getName(),
                        databaseError != null ? databaseError.getMessage() : "database error is null");
            }
        };
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initFireBase();
        mCompositeSubscription = new CompositeSubscription();
    }

    private void uploadPopularMoviesToFireBase(Movies movies){
        mDatabaseReference.child(Constants.FIREBASE_POPULAR)
        .setValue(movies, mCompletionListener);
    }

    private void uploadTopRatedMoviesToFireBase(Movies movies){
        mDatabaseReference.child(Constants.FIREBASE_TOP_RATED)
                .setValue(movies, mCompletionListener);
    }

    private void uploadUpComingMoviesToFireBase(Movies movies){
        mDatabaseReference.child(Constants.FIREBASE_UP_COMING)
                .setValue(movies, mCompletionListener);
    }

    private void uploadNowShowingMoviesToFireBase(Movies movies){
        mDatabaseReference.child(Constants.FIREBASE_NOW_PLAYING)
                .setValue(movies, mCompletionListener);
    }

    private Subscription mMovieDetailSubscription;
    private Subscription mMovieVideosSubscription;

    private void uploadMovieDetails(Long movie_id){
        RxUtils.unSubscribe(mMovieDetailSubscription);
        mMovieDetailSubscription = getMovieDetails.getMovieDetails(movie_id)
                .subscribe(movieDetails -> {
                    mDatabaseReference.child(Constants.FIREBASE_MOVIE_DETAILS)
                            .setValue(movieDetails,mCompletionListener);
                });
    }

    private void uploadMovieVideos(Long movie_id){
        RxUtils.unSubscribe(mMovieVideosSubscription);
        mMovieVideosSubscription = getMovieVideos
                .getMovieVideos(movie_id)
                .subscribe(movieVideos -> {
                    mDatabaseReference.child(Constants.FIREBASE_MOVIE_VIDEOS)
                            .setValue(movieVideos,mCompletionListener);
                });
    }

    private void syncDataToServer(JobParameters jobParameters){

        Observable<Movies> popularMovieObservable =  getPopularMovies
                .getMovies(Utils.getMovieOptions("1"))
                .doOnNext(movies -> {
                    uploadPopularMoviesToFireBase(movies);
                });

        Observable<Movies> topRatedMovieObservable =  getTopRatedMovies
                .getMovies(Utils.getMovieOptions("1"))
                .doOnNext(movies -> {
                    uploadTopRatedMoviesToFireBase(movies);
                });

        Observable<Movies> nowPlayingMovieObservable = getNowPlayingMovies
                .getMovies(Utils.getMovieOptions("1"))
                .doOnNext(movies -> {
                    uploadNowShowingMoviesToFireBase(movies);
                });

        Observable<Movies> upComingMovieObservable = getUpComingMovies
                .getMovies(Utils.getMovieOptions("1"))
                .doOnNext(movies -> {
                    uploadUpComingMoviesToFireBase(movies);
                });



        RxUtils.unSubscribe(mSubscription);

        mSubscription = popularMovieObservable
                .mergeWith(topRatedMovieObservable)
                .mergeWith(nowPlayingMovieObservable)
                .mergeWith(upComingMovieObservable)
                .flatMap(movies -> {
                    return Observable.from(movies.getResults());
                })
                .map(result -> {
                    uploadMovieDetails(result.getId());
                    uploadMovieVideos(result.getId());
                    return result;
                })
                .toList()
                .compose(RxUtils.applyIOScheduler())
                .subscribe(moviesList -> {
                },throwable -> {
                    // Passing true, to reschedule the job
                    jobFinished(jobParameters,true);
                    Toast.makeText(getApplicationContext(),"Job finished with error",Toast.LENGTH_SHORT)
                            .show();
                },()->{
                    // Passing false,as no need to re-schedule
                    Toast.makeText(getApplicationContext(),"Job finished successfully",Toast.LENGTH_SHORT)
                            .show();
                    jobFinished(jobParameters,false);
                });

        mCompositeSubscription.add(mSubscription);

    }


    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(getApplicationContext(),"Job started",Toast.LENGTH_SHORT)
                .show();
        syncDataToServer(jobParameters);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        RxUtils.unSubscribe(mSubscription);
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDatabaseReference.removeValue(mCompletionListener);
        RxUtils.clear(mCompositeSubscription);
        mBasicUseCaseComponents = null;
    }
}
