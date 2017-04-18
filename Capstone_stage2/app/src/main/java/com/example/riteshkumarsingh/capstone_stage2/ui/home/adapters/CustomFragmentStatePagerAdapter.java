package com.example.riteshkumarsingh.capstone_stage2.ui.home.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter{

    private int mTotalCount;

    public CustomFragmentStatePagerAdapter(FragmentManager fm,
                                           int totalCount) {
        super(fm);
        this.mTotalCount = totalCount;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mTotalCount;
    }
}
