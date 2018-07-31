package com.nhankv.calendarlib.spinner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LinearLayoutArrow extends LinearLayout {
    private ImageViewArrowUp mImageViewArrowUp;
    private ImageViewArrowDown mImageViewArrowDown;

    public LinearLayoutArrow(Context context) {
        super(context);
        init(context);
    }

    public LinearLayoutArrow(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LinearLayoutArrow(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LinearLayoutArrow(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        setWeightSum(2);
        setOrientation(VERTICAL);
        setBackgroundColor(context.getResources().getColor(android.R.color.white));
        setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
        initArrow(context);
        addView(mImageViewArrowUp);
        addView(mImageViewArrowDown);
    }

    private void initArrow(Context context) {
        mImageViewArrowUp = new ImageViewArrowUp(context);
//        mImageViewArrowUp.setLayoutParams(new LayoutParams(55, 55, 1.0f));
        mImageViewArrowDown = new ImageViewArrowDown(context);
//        mImageViewArrowDown.setLayoutParams(new LayoutParams(55, 55, 1.0f));
    }

    public ImageViewArrowUp getmImageViewArrowUp() {
        return mImageViewArrowUp;
    }

    public void setmImageViewArrowUp(ImageViewArrowUp mImageViewArrowUp) {
        this.mImageViewArrowUp = mImageViewArrowUp;
    }

    public ImageViewArrowDown getmImageViewArrowDown() {
        return mImageViewArrowDown;
    }

    public void setmImageViewArrowDown(ImageViewArrowDown mImageViewArrowDown) {
        this.mImageViewArrowDown = mImageViewArrowDown;
    }
}
