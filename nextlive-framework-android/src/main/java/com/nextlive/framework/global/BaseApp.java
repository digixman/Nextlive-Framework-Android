package com.nextlive.framework.global;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;

public class BaseApp extends Application {

    protected static BaseApp mInstance;

    protected SharedPreferences mSharedPreferences;

    public static synchronized BaseApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        setSharedPreferences(getSharedPreferences(getPackageName() + "_preferences", MODE_PRIVATE));
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }
    public void setSharedPreferences(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }
    
    public void restartApp() {
        Intent i = getBaseContext().getPackageManager().
                getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}