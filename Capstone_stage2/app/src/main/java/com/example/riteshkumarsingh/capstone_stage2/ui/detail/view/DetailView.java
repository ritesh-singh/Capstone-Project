package com.example.riteshkumarsingh.capstone_stage2.ui.detail.view;

import com.example.riteshkumarsingh.capstone_stage2.core.BaseView;
import com.example.riteshkumarsingh.capstone_stage2.ui.detail.presenter.DetailFragmentPresenter;

/**
 * Created by riteshkumarsingh on 26/04/17.
 */

public interface DetailView extends BaseView{
    void onMovieAndVideoResponse(DetailFragmentPresenter.MovieAndVideo movieAndVideo);
    void launchYouTubeVideo(String key);
}
