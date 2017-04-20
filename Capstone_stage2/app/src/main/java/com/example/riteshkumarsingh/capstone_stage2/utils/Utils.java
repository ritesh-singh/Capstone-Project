package com.example.riteshkumarsingh.capstone_stage2.utils;


import android.net.Uri;

import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public final class Utils {

    public static Uri getImageUri(String size, String file_path){
        Uri imageUri = Uri.parse(Constants.IMAGE_END_POINT)
                .buildUpon()
                .appendPath(size)
                .appendPath(file_path)
                .build();

        return imageUri;
    }
}
