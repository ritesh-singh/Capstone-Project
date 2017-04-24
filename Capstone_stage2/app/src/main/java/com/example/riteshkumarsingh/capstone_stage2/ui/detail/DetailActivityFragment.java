package com.example.riteshkumarsingh.capstone_stage2.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 22/04/17.
 */

public class DetailActivityFragment extends BaseFragment {

    public static DetailActivityFragment newInstance() {
        return new DetailActivityFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,
                container,
                false);
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
