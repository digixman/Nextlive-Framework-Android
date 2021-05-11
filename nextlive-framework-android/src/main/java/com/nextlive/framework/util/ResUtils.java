package com.nextlive.framework.util;

import com.nextlive.framework.global.BaseApp;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.app.ActivityCompat;

public class ResUtils {

    public static String getString(int resId) {
        return BaseApp.getInstance().getResources().getString(resId);
    }

    public static Integer getInteger(int resId) {
        return BaseApp.getInstance().getResources().getInteger(resId);
    }

    public static boolean getBoolean(int resId) {
        return BaseApp.getInstance().getResources().getBoolean(resId);
    }

    public static int getColorInt(int resId) {
        return ActivityCompat.getColor(BaseApp.getInstance(), resId);
    }

    public static ColorStateList getColorStateList(int resId) {
        return ActivityCompat.getColorStateList(BaseApp.getInstance(), resId);
    }

    public static Drawable getDrawable(int resId) {
        return  ActivityCompat.getDrawable(BaseApp.getInstance(), resId);
    }
    public static Drawable getDrawable(String name) {
        return ActivityCompat.getDrawable(BaseApp.getInstance(),BaseApp.getInstance().getResources().getIdentifier(name, "drawable", BaseApp.getInstance().getPackageName()));
    }

    public static int getDimensionPixelSize(int resId) {
        return BaseApp.getInstance().getResources().getDimensionPixelSize(resId);
    }

    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
    public static int pxToDp(int px)
    {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}