package com.example.riteshkumarsingh.capstone_stage2.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

@IntDef({
    Constants.EXPLORE_COUNT,
        Constants.MOVIES_TV_COUNT,
        Constants.CELEB_COUNT
})
@Retention(RetentionPolicy.SOURCE)
public @interface Counts {
}
