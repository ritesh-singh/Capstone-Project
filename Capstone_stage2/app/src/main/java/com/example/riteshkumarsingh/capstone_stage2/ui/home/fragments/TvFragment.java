package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments;

import android.support.v4.app.Fragment;

import com.example.riteshkumarsingh.capstone_stage2.ui.home.base.NavViewsBaseFragment;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class TvFragment extends NavViewsBaseFragment {

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected void setupViewPager() {

    }

    @Override
    protected void setupTabLayout() {

    }

    public static Fragment newInstance() {
        return new TvFragment();
    }
}
