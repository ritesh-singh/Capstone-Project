package com.example.riteshkumarsingh.capstone_stage2.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;

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

        mUnbinder = ButterKnife.bind(this);

        addDetailFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
