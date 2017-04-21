package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.riteshkumarsingh.capstone_stage2.BasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseFragment;

import butterknife.BindView;

/**
 * Created by riteshkumarsingh on 21/04/17.
 */

public abstract class MovieBaseFragment extends BaseFragment implements MovieView {

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    protected static final int SPAN_COUNT_PORTRAIT = 3;
    protected static final int SPAN_COUNT_LANDSCAPE = 5;

    protected BasicUseCaseComponents mBasicUseCaseComponents;

    protected GridLayoutManager mLayoutManager;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBasicUseCaseComponents = null;
    }

    public void showRecyclerView(){
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    public void hideRecyclerView(){
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProgressBar() {
        hideRecyclerView();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        showRecyclerView();
        mProgressBar.setVisibility(View.GONE);
    }
}
