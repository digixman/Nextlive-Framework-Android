package com.nextlive.framework.widget.bounce;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.widget.AppCompatTextView;

import com.nextlive.framework.R;
import com.nextlive.framework.animation.BounceInterpolator;

public class BounceTextView extends AppCompatTextView {

    private float amplitude = 0.2f;
    private int frequency = 20;

    public BounceTextView(Context context) {
        super(context);
    }

    public BounceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setExtraAttrs(context, attrs);
    }

    public BounceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setExtraAttrs(context, attrs);
    }

    private void setExtraAttrs(Context context, AttributeSet attrs)  {setClickable(true);}

    public boolean performClick() {
        Animation animation = AnimationUtils.loadAnimation(this.getContext(), R.anim.bounce);
        animation.setInterpolator(new BounceInterpolator((double) amplitude, (double) frequency));
        this.startAnimation(animation);

        return super.performClick();
    }
}
