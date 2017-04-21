package com.example.riteshkumarsingh.capstone_stage2.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by riteshkumarsingh on 20/04/17.
 */

public final class ImageUtil {

    private static ImageUtil sImageUtil;

    public static ImageUtil getImageUtilInstance() {
        if (sImageUtil == null) {
            sImageUtil = new ImageUtil();
        }
        return sImageUtil;
    }

    public void loadImage(Context context, String url, ImageView target) {
        Picasso.with(context)
                .load(url)
                .into(target);
    }
}
