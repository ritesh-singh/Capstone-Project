package com.example.riteshkumarsingh.capstone_stage2.ui.detail.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseActivity;
import com.example.riteshkumarsingh.capstone_stage2.utils.ActivityUtils;

import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 22/04/17.
 */

public class DetailActivity extends BaseActivity {

    private void addDetailFragment(){
        ActivityUtils
                .addAndReplaceFragment(DetailActivityFragment.newInstance(),
                        R.id.container,
                        getSupportFragmentManager());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Slide slide = new Slide(Gravity.RIGHT);
        slide.setInterpolator(new LinearInterpolator());
        getWindow().setEnterTransition(slide);
        getWindow().setReturnTransition(slide);

        mUnbinder = ButterKnife.bind(this);

        addDetailFragment();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
