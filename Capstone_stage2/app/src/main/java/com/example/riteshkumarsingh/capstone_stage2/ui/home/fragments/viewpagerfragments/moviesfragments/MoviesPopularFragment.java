package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riteshkumarsingh.capstone_stage2.DaggerBasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.MainApplication;
import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.adapters.MovieRecyclerViewAdapter;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.MovieBaseFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.presenter.MoviesPopularPresenter;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class MoviesPopularFragment extends MovieBaseFragment {

    @Inject
    MoviesPopularPresenter moviesPopularPresenter;

    private MovieRecyclerViewAdapter mMovieRecyclerViewAdapter;

    private void initDagger(){
        mBasicUseCaseComponents = DaggerBasicUseCaseComponents.builder()
                .appComponent(((MainApplication) getActivity().getApplication()).getAppComponent())
                .build();

        mBasicUseCaseComponents.inject(this);
    }

    public static Fragment newInstance() {
        return new MoviesPopularFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_view_pager,
                container,
                false);
    }


    private void initRecyclerView(){
        mRecyclerView.setHasFixedSize(true);
        mMovieRecyclerViewAdapter = new MovieRecyclerViewAdapter(new ArrayList<>());

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT_PORTRAIT);
        } else {
            mLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT_LANDSCAPE);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mMovieRecyclerViewAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moviesPopularPresenter.setMoviePopularView(this);
        mUnbinder = ButterKnife.bind(this,view);

        initRecyclerView();

        moviesPopularPresenter.fetchMovies(Utils.getMovieOptions("1"));
    }


    @Override
    public void showResult(Movies movies) {
        mMovieRecyclerViewAdapter.swap(movies.getResults());
    }

    @Override
    public void showError() {

    }
}
