package com.example.riteshkumarsingh.capstone_stage2.utils;

import android.content.Context;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public final class UiUtils {

    public static float getScreenDensity(Context context){
        return context.getResources().getDisplayMetrics().density;
    }
}
