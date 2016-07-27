package com.tedkim.android.tviews.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Ted
 */
public class ViewUtils {

    /**
     * Convert dp to px
     *
     * @param context context
     * @param px      pixel
     * @return dp
     */
    public static int convertPxToDp(Context context, float px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return (int) dp;
    }

    /**
     * Convert px to dp
     *
     * @param context context
     * @param dp      dp
     * @return pixel
     */
    public static int convertDpToPixels(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density);
    }

}
