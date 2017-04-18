package com.example.riteshkumarsingh.capstone_stage2.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.riteshkumarsingh.capstone_stage2.core.BaseActivity;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.activities.HomeActivity;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent homeActivityIntent =
                            new Intent(SplashScreenActivity.this,
                                    HomeActivity.class);
                    startActivity(homeActivityIntent);
                }
            }
        });

        sleepThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
