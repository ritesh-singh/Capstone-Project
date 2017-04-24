package com.example.riteshkumarsingh.capstone_stage2.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by riteshkumarsingh on 22/04/17.
 */

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
