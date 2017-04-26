package com.example.riteshkumarsingh.capstone_stage2.ui.detail.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.riteshkumarsingh.capstone_stage2.BasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.DaggerBasicUseCaseComponents;
import com.example.riteshkumarsingh.capstone_stage2.MainApplication;
import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseFragment;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieDetails;
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.MovieVideos;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.presenter.DetailFragmentPresenter;
import com.example.riteshkumarsingh.capstone_stage2.utils.ImageUtil;
import com.example.riteshkumarsingh.capstone_stage2.utils.UiUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;

import java.util.logging.Logger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 22/04/17.
 */

public class DetailActivityFragment extends BaseFragment
        implements  DetailView{

    public static final String INTENT_MOVIE_ID_KEY = "INTENT_MOVIE_ID_KEY";

    private BasicUseCaseComponents mBasicUseCaseComponents;
    private Long mMovieId;

    @Inject
    DetailFragmentPresenter mDetailFragmentPresenter;

    @BindView(R.id.iv_back_drop)
    ImageView mBackDropImageView;

    @BindView(R.id.iv_poster)
    ImageView mPosterImageView;

    @BindView(R.id.iv_play_button)
    ImageView mPlayButtonView;

    @BindView(R.id.tv_title)
    TextView mTitle;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mRootContainer;

    public static DetailActivityFragment newInstance() {
        return new DetailActivityFragment();
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
        mMovieId = getActivity().getIntent().getExtras().getLong(INTENT_MOVIE_ID_KEY);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,
                container,
                false);
        mUnbinder = ButterKnife.bind(this, rootView);
        mDetailFragmentPresenter.setDetailView(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDetailFragmentPresenter.fetchMovieDetailsFromRepo(mMovieId);
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

    @Override
    public void onStart() {
        super.onStart();
        mDetailFragmentPresenter.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mDetailFragmentPresenter.stop();
    }

    private void bindDataWithUI(MovieDetails movieDetails){
        ImageUtil
                .getImageUtilInstance()
                .loadImage(getContext(),
                        Utils.getImagePath(Utils.getPosterImageSize(UiUtils.getScreenDensity(getContext())),
                                movieDetails.getBackdropPath()),
                        mBackDropImageView);
        ImageUtil.getImageUtilInstance()
                .loadImage(getContext(),
                        Utils.getImagePath(Utils.getPosterImageSize(UiUtils.getScreenDensity(getContext())),
                                movieDetails.getPosterPath()),
                        mPosterImageView);

        mTitle.setText(movieDetails.getTitle());
    }

    @Override
    public void onMovieDetailResponse(MovieDetails movieDetails) {
        bindDataWithUI(movieDetails);
    }

    private void hideRootContainer(){
        mRootContainer.setVisibility(View.INVISIBLE);
    }

    private void showRootContainer(){
        mRootContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBar() {
        hideRootContainer();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
        showRootContainer();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onMovieVideoResponse(MovieVideos movieVideos) {

    }
}
