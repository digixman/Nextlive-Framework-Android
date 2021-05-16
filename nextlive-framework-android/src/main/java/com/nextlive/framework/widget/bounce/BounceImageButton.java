package com.nextlive.framework.widget.bounce;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.widget.AppCompatImageButton;

import com.nextlive.framework.R;
import com.nextlive.framework.animation.BounceInterpolator;

public class BounceImageButton extends AppCompatImageButton {

    private float amplitude = 0.2f;
    private int frequency = 20;

    public BounceImageButton(Context context) {
        super(context);
    }

    public BounceImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setExtraAttrs(context, attrs);
    }

    public BounceImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setExtraAttrs(context, attrs);
    }

    private void setExtraAttrs(Context context, AttributeSet attrs) {}

    public boolean performClick() {
        Animation animation = AnimationUtils.loadAnimation(this.getContext(), R.anim.bounce);
        animation.setInterpolator(new BounceInterpolator((double) amplitude, (double) frequency));
        this.startAnimation(animation);

        return super.performClick();
    }
}
