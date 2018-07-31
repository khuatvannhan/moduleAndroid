package com.nhankv.calendarlib.spinner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.view.Gravity.CENTER_VERTICAL;

public class LinearLayoutSpinner extends LinearLayout {
    private TextViewTitle mTxtTitle;
    private LinearLayoutNumber mLinearLayoutNumber;

    public LinearLayoutSpinner(Context context) {
        super(context);
        init(context);
    }

    public LinearLayoutSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LinearLayoutSpinner(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LinearLayoutSpinner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        initView(context);
        addView(context);
    }

    private void initView(Context context) {
        mTxtTitle = new TextViewTitle(context);
        mLinearLayoutNumber = new LinearLayoutNumber(context);
        setWeightSum(2);
        setGravity(CENTER_VERTICAL);
        setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
    }

    private void addView(Context context) {
        addView(mTxtTitle);
        addView(mLinearLayoutNumber);
    }

    public TextViewTitle getmTxtTitle() {
        return mTxtTitle;
    }

    public void setmTxtTitle(TextViewTitle mTxtTitle) {
        this.mTxtTitle = mTxtTitle;
    }

    public LinearLayoutNumber getmLinearLayoutNumber() {
        return mLinearLayoutNumber;
    }

    public void setmLinearLayoutNumber(LinearLayoutNumber mLinearLayoutNumber) {
        this.mLinearLayoutNumber = mLinearLayoutNumber;
    }
}
