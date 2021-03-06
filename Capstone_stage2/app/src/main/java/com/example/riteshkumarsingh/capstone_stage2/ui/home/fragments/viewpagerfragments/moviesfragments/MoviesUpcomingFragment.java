package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riteshkumarsingh.capstone_stage2.DaggerBasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.MainApplication;
import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseFragment;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.MovieBaseFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.MovieView;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.presenter.MoviesUpComingPresenter;
import com.example.riteshkumarsingh.capstone_stage2.utils.UiUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class MoviesUpcomingFragment extends MovieBaseFragment {

    @Inject
    MoviesUpComingPresenter mMoviesUpComingPresenter;

    public static Fragment newInstance() {
        return new MoviesUpcomingFragment();
    }

    private void initDagger(){
        mBasicUseCaseComponents = DaggerBasicUseCaseComponents.builder()
                .appComponent(((MainApplication) getActivity().getApplication()).getAppComponent())
                .build();

        mBasicUseCaseComponents.inject(this);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_view_pager,
                container,
                false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMoviesUpComingPresenter.setMoviePopularView(this);
        mUnbinder = ButterKnife.bind(this,view);

        initRecyclerView(Constants.MOVIES_UPCOMIMG);

        mMoviesUpComingPresenter.start();
        mMoviesUpComingPresenter.fetchMovies(Utils.getMovieOptions("1"));
    }

    @Override
    public void showResult(Movies movies) {
        mMovieRecyclerViewAdapter.swap(movies.getResults());
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMoviesUpComingPresenter.stop();
    }

    @Override
    public boolean isNetworkActive() {
        return UiUtils.isNetworkActive(getContext());
    }
}
