package com.example.riteshkumarsingh.capstone_stage2.ui.detail.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.riteshkumarsingh.capstone_stage2.data.models.movies.VideoResult;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.adapters.TrailerRecyclerViewAdapter;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.presenter.DetailFragmentPresenter;
import com.example.riteshkumarsingh.capstone_stage2.utils.ImageUtil;
import com.example.riteshkumarsingh.capstone_stage2.utils.UiUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.Utils;

import java.util.List;

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

    @BindView(R.id.tv_title)
    TextView mTitle;

    @BindView(R.id.tv_year)
    TextView mTvYear;

    @BindView(R.id.tv_genre)
    TextView mTvGenre;

    @BindView(R.id.tv_runtime)
    TextView mTvRunTime;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mRootContainer;

    @BindView(R.id.rv_videos)
    RecyclerView mTrailersRecyclerView;

    @BindView(R.id.tv_overview)
    TextView mTvOverView;

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
        mDetailFragmentPresenter.fetchMovieDetailsAndVideos(mMovieId);
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

    private void initTrailerRecyclerView(List<VideoResult> videoResults){
        mTrailersRecyclerView.setHasFixedSize(true);
        TrailerRecyclerViewAdapter trailerRecyclerViewAdapter =
                new TrailerRecyclerViewAdapter(videoResults,mDetailFragmentPresenter);
        mTrailersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mTrailersRecyclerView.setAdapter(trailerRecyclerViewAdapter);
    }

    private void bindDataWithUI(MovieDetails movieDetails,
                                MovieVideos movieVideos){
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
        mTvYear.setText(movieDetails.getReleaseDate());
        mTvGenre.setText(Utils.convertStringToPipeSeparatedString(movieDetails.getGenres()));
        mTvRunTime.setText(movieDetails.getRuntime() + " mins");
        mTvOverView.setText(movieDetails.getOverview());
        initTrailerRecyclerView(movieVideos.getVideoResults());
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
        if (mProgressBar == null)
            return;
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        showRootContainer();
        if(mProgressBar == null)
            return;
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onMovieAndVideoResponse(DetailFragmentPresenter.MovieAndVideo movieAndVideo) {
        bindDataWithUI(movieAndVideo.movieDetails,
                movieAndVideo.movieVideos);
    }

    @Override
    public void launchYouTubeVideo(String key) {
        Intent appIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("vnd.youtube:" + key));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + key));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }

    @Override
    public boolean isNetworkActive() {
        return UiUtils.isNetworkActive(getContext());
    }
}
