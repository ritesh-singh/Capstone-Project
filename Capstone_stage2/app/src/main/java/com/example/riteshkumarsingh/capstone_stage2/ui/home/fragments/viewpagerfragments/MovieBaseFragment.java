package com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.riteshkumarsingh.capstone_stage2.BasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.common.GridViewItemDecorator;
import com.example.riteshkumarsingh.capstone_stage2.constants.MovieSections;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.view.DetailActivity;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.view.DetailActivityFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.adapters.MovieRecyclerViewAdapter;

import java.util.ArrayList;

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

    protected MovieRecyclerViewAdapter mMovieRecyclerViewAdapter;

    protected void initRecyclerView(@MovieSections String movieSection){
        mRecyclerView.setHasFixedSize(true);
        mMovieRecyclerViewAdapter = new MovieRecyclerViewAdapter(new ArrayList<>(),
                movieSection);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT_PORTRAIT);
        } else {
            mLayoutManager = new GridLayoutManager(getContext(),SPAN_COUNT_LANDSCAPE);
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mMovieRecyclerViewAdapter);

        mRecyclerView.addItemDecoration(new GridViewItemDecorator());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBasicUseCaseComponents = null;
    }

    public void showRecyclerView() {
        if (mRecyclerView == null)
            return;
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    public void hideRecyclerView() {
        if (mRecyclerView == null)
            return;
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

    @Override
    public void onMovieItemClick(Long movie_id) {
        Intent detailActivityIntent = new Intent(getActivity(), DetailActivity.class);
        detailActivityIntent.putExtra(DetailActivityFragment.INTENT_MOVIE_ID_KEY,movie_id);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
        startActivity(detailActivityIntent,bundle);
    }
}
