package com.example.riteshkumarsingh.capstone_stage2.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

@IntDef({Constants.EXPLORE_LAUNCH_MODE,
        Constants.MOVIE_LAUNCH_MODE,
        Constants.TVSERIES_LAUNCH_MODE,
        Constants.CELEBS_LAUNCH_MODE

})
@Retention(RetentionPolicy.SOURCE)
public @interface LaunchModes {
}
