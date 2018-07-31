package com.nhankv.calendarlib.spinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.view.Gravity.CENTER_VERTICAL;

@SuppressLint("ViewConstructor")
public class LinearLayoutNumber extends LinearLayout {
    private TextViewNumber mTxtNumber;
    private LinearLayoutArrow mLinearLayoutArrow;
    public LinearLayoutNumber(Context context) {
        super(context);
        init(context);
    }

    public LinearLayoutNumber(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LinearLayoutNumber(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LinearLayoutNumber(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        setWeightSum(3);
        setOrientation(HORIZONTAL);
        setBackgroundColor(context.getResources().getColor(android.R.color.white));
        initView(context);
        addView(context);
    }

    private void initView(Context context) {
        mTxtNumber = new TextViewNumber(context);
        mLinearLayoutArrow = new LinearLayoutArrow(context);
        setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
        setGravity(CENTER_VERTICAL);
    }

    private void addView(Context context) {
        addView(mTxtNumber);
        addView(mLinearLayoutArrow);
        mTxtNumber.setText("0");
    }

    public TextViewNumber getmTxtNumber() {
        return mTxtNumber;
    }

    public void setmTxtNumber(TextViewNumber mTxtNumber) {
        this.mTxtNumber = mTxtNumber;
    }

    public LinearLayoutArrow getmLinearLayoutArrow() {
        return mLinearLayoutArrow;
    }

    public void setmLinearLayoutArrow(LinearLayoutArrow mLinearLayoutArrow) {
        this.mLinearLayoutArrow = mLinearLayoutArrow;
    }
}
