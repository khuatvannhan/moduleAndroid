package com.nhankv.calendarlib.datetime;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.nhankv.calendarlib.ListenerDateTime;
import com.nhankv.calendarlib.calendar.CalendarViewCustom;
import com.nhankv.calendarlib.time.LinearLayoutTimeView;

public class LinearLayoutDateTime extends LinearLayout {
    private LinearLayoutTimeView mLinearLayoutTime;
    private CalendarViewCustom mCalendarViewCustom;
    private ListenerDateTime mListenerDateTime;

    public LinearLayoutDateTime(Context context) {
        super(context);
        init(context);
    }

    public LinearLayoutDateTime(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LinearLayoutDateTime(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LinearLayoutDateTime(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        initView(context);
        addView(context);
    }

    private void initView(Context context) {
        setWeightSum(6);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setPadding(10, 10, 30, 10);
    }

    private void addView(Context context) {
        mLinearLayoutTime = new LinearLayoutTimeView(context);
        mCalendarViewCustom = new CalendarViewCustom(context);
        addView(mCalendarViewCustom);
        addView(mLinearLayoutTime);
    }

    public LinearLayoutTimeView getmLinearLayoutTime() {
        return mLinearLayoutTime;
    }

    public void setmLinearLayoutTime(LinearLayoutTimeView mLinearLayoutTime) {
        this.mLinearLayoutTime = mLinearLayoutTime;
    }

    public CalendarViewCustom getmCalendarViewCustom() {
        return mCalendarViewCustom;
    }

    public void setmCalendarViewCustom(CalendarViewCustom mCalendarViewCustom) {
        this.mCalendarViewCustom = mCalendarViewCustom;
    }

    public void setOnClickListenerDateTime(ListenerDateTime listenerDateTime) {
        if (mLinearLayoutTime != null) {
            mLinearLayoutTime.setOnClickListenerDateTime(listenerDateTime);
        }
        if (mCalendarViewCustom != null) {
            mCalendarViewCustom.setOnClickListenerDateTime(listenerDateTime);
        }
    }
}
