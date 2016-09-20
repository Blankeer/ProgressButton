package com.blanke.progressbutton;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

/**
 */
public class ProgressButton extends Button {
    private MaterialProgressDrawable mProgressDrawable;
    private int progressPadding = 0;//loadDrawable padding
    private boolean isLoading = false;
    private CharSequence text;
    private int h;//水平方向的长度
    private int v;//垂直方向的长度

    public ProgressButton(Context context) {
        this(context, null);
        init();
    }

    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        mProgressDrawable.setColorSchemeColors(Color.BLUE);
        mProgressDrawable.setAlpha(255);
        mProgressDrawable.setBackgroundColor(Color.TRANSPARENT);
        post(new Runnable() {
            @Override
            public void run() {
                initValue();
            }
        });
    }

    private void initValue() {
        h = getRight() - getLeft();
        v = getBottom() - getTop();
        //计算loadDrawable位置
        int l = (h - v) / 2;
        int r = l + v;
        int t = 0;
        int b = v;
        if (v > h) {
            l = 0;
            r = h;
            t = (v - h) / 2;
            b = t + h;
            t -= getPaddingTop();
            b -= getPaddingTop();
        } else {
            l -= getPaddingLeft();
            r -= getPaddingLeft();
        }
        l += progressPadding;
        r -= progressPadding;
        t += progressPadding;
        b -= progressPadding;
        mProgressDrawable.setBounds(l, t, r, b);
    }

    private void setProgressDrawable() {
        if (v > h) {
            setCompoundDrawables(null, mProgressDrawable, null, null);
        } else {
            setCompoundDrawables(mProgressDrawable, null, null, null);
        }
    }

    private void setProgressLoading(boolean loading) {
        if (loading) {
            setProgressDrawable();
            mProgressDrawable.start();
        } else {
            mProgressDrawable.stop();
            setCompoundDrawables(null, null, null, null);
        }
    }

    public void setLoading(boolean isLoading) {
        if (this.isLoading != isLoading) {
            this.isLoading = isLoading;
            setProgressLoading(isLoading);
            setClickable(!isLoading);
            if (isLoading) {
                text = getText();
                setText("");
            } else {
                setText(text);
            }
        }
    }

    @Override
    public boolean performClick() {
        boolean re = super.performClick();
        if (re) {
            setLoading(true);
        }
        return re;
    }

    public MaterialProgressDrawable getProgressDrawable() {
        return mProgressDrawable;
    }

    public int getProgressPadding() {
        return progressPadding;
    }

    public void setProgressPadding(int progressPadding) {
        this.progressPadding = progressPadding;
    }
}