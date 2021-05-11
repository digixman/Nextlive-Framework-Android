package com.nextlive.framework.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;

import com.nextlive.framework.activity.BaseActivity;

public class BaseDialog extends Dialog {

    /**
     * Constructor
     *
     * @param context
     */
    public BaseDialog(Context context) {
        super(context);
        if (context instanceof BaseActivity) {
            setOwnerActivity((BaseActivity) context);
        }
        init();
    }

    /**
     * Constructor
     *
     * @param context
     * @param theme
     */
    public BaseDialog(Context context, int theme) {
        super(context, theme);
        if (context instanceof BaseActivity) {
            setOwnerActivity((BaseActivity) context);
        }
        init();
    }

    /**
     * Constructor
     *
     * @param context
     * @param cancelable
     * @param cancelListener
     */
    public BaseDialog(Context context, boolean cancelable,
                      OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        if (context instanceof BaseActivity) {
            setOwnerActivity((BaseActivity) context);
        }
        init();
    }

    protected void hideSystemUI(){
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void init() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        this.getWindow().setLayout(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        this.getWindow().getAttributes().gravity = Gravity.CENTER_HORIZONTAL
                | Gravity.CENTER_VERTICAL;
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(true);
    }
}