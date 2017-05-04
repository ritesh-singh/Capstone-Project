package com.example.riteshkumarsingh.capstone_stage2.data.sync;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

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
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;

/**
 * Created by riteshkumarsingh on 04/05/17.
 */


/**
 *  Job service that will be used by the Job Scheduler,
 *  when scheduled.
 */

public class JobSchedulerService extends JobService {

    private DatabaseReference mDataBase;

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

    private BasicUseCaseComponents mBasicUseCaseComponents;

    private Subscription mSubscription;

    private DatabaseReference.CompletionListener mCompletionListener;

    private void initDagger(){
        mBasicUseCaseComponents = DaggerBasicUseCaseComponents.builder()
                .appComponent(((MainApplication) getApplication()).getAppComponent())
                .build();

        mBasicUseCaseComponents.add(this);
    }

    private void initFireBase() {
        mDataBase = FirebaseDatabase.getInstance().getReference();

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
    }

    private void uploadPopularMoviesToFireBase(List<Movies> moviesList){
        mDataBase.child(Constants.FIREBASE_POPULAR)
        .setValue(moviesList, mCompletionListener);
    }

    private void uploadTopRatedMoviesToFireBase(List<Movies> moviesList){
        mDataBase.child(Constants.FIREBASE_TOP_RATED)
                .setValue(moviesList, mCompletionListener);
    }

    private void uploadUpComingMoviesToFireBase(List<Movies> moviesList){
        mDataBase.child(Constants.FIREBASE_UP_COMING)
                .setValue(moviesList, mCompletionListener);
    }

    private void uploadNowShowingMoviesToFireBase(List<Movies> moviesList){
        mDataBase.child(Constants.FIREBASE_NOW_SHOWING)
                .setValue(moviesList, mCompletionListener);
    }


    /**
     * This function is responsible for syncing all data to
     * firebase server.
     */
    private void syncDataToServer(JobParameters jobParameters){
        // TODO - call this, when the task is completed.

        // It takes 2 params
        // 1.jobParameters - the current job, so that it knows which wakelock can be released
        // 2.boolean - indicating whether you’d like to reschedule the job.
        // If you pass in true, this will kick off the JobScheduler’s exponential backoff logic for you
//        jobFinished(jobParameters,!success);

        Observable<List<Movies>> popularMovieObservable =  getPopularMovies
                .getMovies(Utils.getMovieOptions("1"))
                .toList()
                .doOnNext(moviesList -> {
                    uploadPopularMoviesToFireBase(moviesList);
                });
        Observable<List<Movies>> topRatedMovieObservable =  getTopRatedMovies
                .getMovies(Utils.getMovieOptions("1"))
                .toList()
                .doOnNext(moviesList -> {
                    uploadTopRatedMoviesToFireBase(moviesList);
                });
        Observable<List<Movies>> nowPlayingMovieObservable = getNowPlayingMovies
                .getMovies(Utils.getMovieOptions("1"))
                .toList()
                .doOnNext(moviesList -> {
                    uploadNowShowingMoviesToFireBase(moviesList);
                });
        Observable<List<Movies>> upComingMovieObservable = getUpComingMovies
                .getMovies(Utils.getMovieOptions("1"))
                .toList()
                .doOnNext(moviesList -> {
                    uploadUpComingMoviesToFireBase(moviesList);
                });

        RxUtils.unSubscribe(mSubscription);

        mSubscription = popularMovieObservable
                .mergeWith(topRatedMovieObservable)
                .mergeWith(nowPlayingMovieObservable)
                .mergeWith(upComingMovieObservable)
                .compose(RxUtils.applyIOScheduler())
                .subscribe(moviesList -> {
                },throwable -> {
                    // Passing true, to reschedule the job
                    jobFinished(jobParameters,true);
                },()->{
                    // Passing false,as no need to re-schedule
                    jobFinished(jobParameters,false);
                });

    }


    /**
     * Called by system - when it time to execute
     *
     * return false - let system know all work has been completed (for simple task)
     * return true - for complicated task
     *
     * Job service run on main thread by default.
     */
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        syncDataToServer(jobParameters);
        return true; // return true - tell system long running task is running, it should hold on to wakelock for little longer.
    }


    /**
     * called by the system if the job is cancelled before being finished.
     * such as when the device has been unplugged or if WiFi is no longer available.
     * So use this method for any safety checks and clean up you may need to do in response to a half-finished job
     *
     * Then, return true if you’d like the system to reschedule the job,
     * or false if it doesn’t matter and the system will drop this job
     */
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        RxUtils.unSubscribe(mSubscription);
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBasicUseCaseComponents = null;
        mDataBase = null;
    }
}
