package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.adapters.CustomFragmentStatePagerAdapter;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.base.NavViewsBaseFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class MoviesFragment extends NavViewsBaseFragment {

    @BindView(R.id.viewpager)
    public ViewPager mViewPager;

    @BindView(R.id.tabs)
    public TabLayout mTabLayout;

    @BindArray(R.array.movies)
    String[] mMoviesTabArray;

    public static Fragment newInstance() {
        return new MoviesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie,container,false);
        mUnbinder = ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager();
        setupTabLayout();
    }

    @Override
    protected void setupViewPager() {
        CustomFragmentStatePagerAdapter customFragmentStatePagerAdapter =
                new CustomFragmentStatePagerAdapter(getChildFragmentManager(),
                        Constants.MOVIES_TV_COUNT,
                        Constants.MOVIE_LAUNCH_MODE,
                        Arrays.asList(mMoviesTabArray));

        mViewPager.setAdapter(customFragmentStatePagerAdapter);
    }

    @Override
    protected void setupTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
