package com.example.riteshkumarsingh.capstone_stage2.core;

import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class BaseFragment extends Fragment {

    protected Unbinder mUnbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
