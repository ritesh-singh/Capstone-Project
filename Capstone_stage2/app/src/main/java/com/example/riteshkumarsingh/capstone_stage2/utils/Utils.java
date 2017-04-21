package com.example.riteshkumarsingh.capstone_stage2.utils;


import android.net.Uri;

import com.example.riteshkumarsingh.capstone_stage2.BuildConfig;
import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public final class Utils {

    public static String getImagePath(final String size, final String file_path) {
        Uri imageUri = Uri.parse(Constants.IMAGE_END_POINT)
                .buildUpon()
                .appendPath(size)
                .build();

        return new StringBuilder(imageUri.toString())
                .append(file_path).toString();
    }

    public static Map<String,String> getMovieOptions(String page_no){
        Map<String,String> options = new HashMap<>();
        options.put(Constants.API_KEY, BuildConfig.APP_KEY);
        options.put(Constants.PAGE_NO,page_no);
        return options;
    }

    public static String getPosterImageSize(final float density) {
        String imageSize = null;

        if (density <= 1.0f) { // small 120 - 160
            imageSize = Constants.POSTER_IMAGE_SIZE_W_154;
        } else if (density > 1.1f && density <= 1.5f) { // medium 160- 240
            imageSize = Constants.POSTER_IMAGE_SIZE_W_185;
        } else if (density > 1.51f && density <= 2.0f) { // large 240 - 320
            imageSize = Constants.POSTER_IMAGE_SIZE_W_342;
        } else if (density > 2.1f && density <= 3.0f) { // extra large 320 - 480
            imageSize = Constants.POSTER_IMAGE_SIZE_W_500;
        } else if (density > 3.1f) { // extra extra large >=480
            imageSize = Constants.POSTER_IMAGE_SIZE_W_780;
        }

        return imageSize;
    }
}
