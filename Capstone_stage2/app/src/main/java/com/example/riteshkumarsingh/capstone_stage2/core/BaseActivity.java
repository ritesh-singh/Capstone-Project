package com.example.riteshkumarsingh.capstone_stage2.core;

import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */


/**
 *  Base Activity class for all other activities.
 *  All common activity methods should go here.
 */
public class BaseActivity extends AppCompatActivity {
    protected Unbinder mUnbinder;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
