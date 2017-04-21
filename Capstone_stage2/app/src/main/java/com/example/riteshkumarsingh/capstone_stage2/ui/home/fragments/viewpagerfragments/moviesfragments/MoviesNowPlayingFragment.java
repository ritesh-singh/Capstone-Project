package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseFragment;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.Movies;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.MovieView;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.explorefragments.ExploreTvShowsFragment;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class MoviesNowPlayingFragment extends BaseFragment implements MovieView {

    public static Fragment newInstance() {
        return new MoviesNowPlayingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_view_pager,
                container,
                false);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showResult(Movies movies) {

    }

    @Override
    public void showError() {

    }
}
