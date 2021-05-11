package com.nextlive.framework.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.*;
import android.util.AttributeSet;
 
import com.android.volley.toolbox.NetworkImageView;
import com.nextlive.framework.global.BaseApp;
import com.nextlive.framework.util.ResUtils;

public class FadeInNetworkImageView extends NetworkImageView {
 
    private static final int FADE_IN_TIME_MS = 700;
 
    public FadeInNetworkImageView(Context context) {
        super(context);
    }
 
    public FadeInNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    public FadeInNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
 
    @Override
    public void setImageBitmap(Bitmap bm) {
    	if (bm != null) {
    		TransitionDrawable td = new TransitionDrawable(new Drawable[]{
                    new ColorDrawable(ResUtils.getColorInt(android.R.color.transparent)),
                    new BitmapDrawable(getContext().getResources(), bm)
            });
     
            setImageDrawable(td);
            td.startTransition(FADE_IN_TIME_MS);
    	}
    }
}
