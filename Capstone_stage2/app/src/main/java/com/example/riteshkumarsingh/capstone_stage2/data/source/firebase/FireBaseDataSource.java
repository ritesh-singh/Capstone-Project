package com.example.riteshkumarsingh.capstone_stage2.data.source.firebase;

import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.data.source.DataSource;
import com.example.riteshkumarsingh.capstone_stage2.di.scope.FragmentScope;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

@FragmentScope
public class FireBaseDataSource implements DataSource {

    private DatabaseReference mDatabaseReference;

    @Inject
    public FireBaseDataSource(DatabaseReference databaseReference){
        this.mDatabaseReference = databaseReference;
    }

    @Override
    public Observable<Movies> getPopularMovies(Map<String, String> options) {
        return Observable.create(subscriber -> {
            mDatabaseReference.child(Constants.FIREBASE_POPULAR)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            subscriber.onNext(dataSnapshot.getValue(Movies.class));
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            subscriber.onError(new Throwable(databaseError.getMessage()));
                        }
                    });
        });
    }

    @Override
    public Observable<Movies> getTopRatedMovies(Map<String, String> options) {
        return Observable.create(subscriber -> {
            mDatabaseReference.child(Constants.FIREBASE_TOP_RATED)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            subscriber.onNext(dataSnapshot.getValue(Movies.class));
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            subscriber.onError(new Throwable(databaseError.getMessage()));
                        }
                    });
        });
    }

    @Override
    public Observable<Movies> getNowPlayingMovies(Map<String, String> options) {
        return Observable.create(subscriber -> {
            mDatabaseReference.child(Constants.FIREBASE_NOW_PLAYING)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            subscriber.onNext(dataSnapshot.getValue(Movies.class));
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            subscriber.onError(new Throwable(databaseError.getMessage()));
                        }
                    });
        });
    }

    @Override
    public Observable<Movies> getUpComingMovies(Map<String, String> options) {
        return Observable.create(subscriber -> {
            mDatabaseReference.child(Constants.FIREBASE_UP_COMING)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            subscriber.onNext(dataSnapshot.getValue(Movies.class));
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            subscriber.onError(new Throwable(databaseError.getMessage()));
                        }
                    });
        });
    }

    @Override
    public Observable<Movies> getLatestMovies(Map<String, String> options) {
        return null;
    }

    @Override
    public Observable<MovieDetails> getMovieDetails(Long movie_id) {
        DatabaseReference movieDetailDataBaseReference
                = mDatabaseReference
                .child(Constants.FIREBASE_MOVIE_DETAILS)
                .child(String.valueOf(movie_id));

        return Observable.create(subscriber -> {
            movieDetailDataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    subscriber.onNext(dataSnapshot.getValue(MovieDetails.class));
                    subscriber.onCompleted();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    subscriber.onError(new Throwable(databaseError.getMessage()));
                }
            });
        });
    }

    @Override
    public Observable<MovieVideos> getMovieVideos(Long movie_id) {
        DatabaseReference movieVideoDataBaseReference  = mDatabaseReference
                .child(Constants.FIREBASE_MOVIE_VIDEOS)
                .child(String.valueOf(movie_id));

        return Observable.create(subscriber -> {
            movieVideoDataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
               @Override
               public void onDataChange(DataSnapshot dataSnapshot) {
                   subscriber.onNext(dataSnapshot.getValue(MovieVideos.class));
                   subscriber.onCompleted();
               }

               @Override
               public void onCancelled(DatabaseError databaseError) {
                    subscriber.onError(new Throwable(databaseError.getMessage()));
               }
           });
        });
    }
}
