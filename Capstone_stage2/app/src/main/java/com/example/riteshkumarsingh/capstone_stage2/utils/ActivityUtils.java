package com.example.riteshkumarsingh.capstone_stage2.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public final class ActivityUtils {
    /**
     *
     * @param fragment - fragment to add
     * @param container - fragment container
     * @param fragmentManager - supportFragment manager
     */
    public static void addAndReplaceFragment(Fragment fragment,
                                      int container, FragmentManager fragmentManager){
        fragmentManager.beginTransaction()
                .replace(container,fragment)
                .commit();
    }
}
