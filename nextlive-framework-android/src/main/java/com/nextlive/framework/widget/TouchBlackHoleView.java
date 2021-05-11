package com.nextlive.framework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TouchBlackHoleView extends View {

    private boolean mTouchDisabled=false;

    public TouchBlackHoleView(Context context) {
        super(context);
    }
    public TouchBlackHoleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public TouchBlackHoleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public void setTouchDisabled(boolean value) {
        mTouchDisabled = value;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return mTouchDisabled;
    }
}
