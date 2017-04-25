package com.example.riteshkumarsingh.capstone_stage2.constants;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by riteshkumarsingh on 25/04/17.
 */

@StringDef({
        Constants.MOVIES_POPULAR,
        Constants.MOVIES_TOP_RATED,
        Constants.MOVIES_NOW_PLAYING,
        Constants.MOVIES_UPCOMIMG,
})
@Retention(RetentionPolicy.SOURCE)
public @interface MovieSections {
}
