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

    private void init(Context context) {
        initView(context);
        addView(context);
    }

    private void initView(Context context) {
        setWeightSum(6);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setPadding(10, 10, 10, 10);
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

    public String getTime() {
        if (mLinearLayoutTime != null) {
            return mLinearLayoutTime.getmIndexHour() + ":" + mLinearLayoutTime.getmIndexMinute() +
                    ":" + mLinearLayoutTime.getmIndexSecond();
        }
        return "0:0:0";
    }

    public int getHour() {
        if (mLinearLayoutTime != null) {
            return mLinearLayoutTime.getmIndexHour();
        }
        return 0;
    }

    public int getMinute() {
        if (mLinearLayoutTime != null) {
            return mLinearLayoutTime.getmIndexMinute();
        }
        return 0;
    }

    public int getSecond() {
        if (mLinearLayoutTime != null) {
            mLinearLayoutTime.getmIndexSecond();
        }
        return 0;
    }

    public int getYear() {
        try {
            if (mCalendarViewCustom != null) {
                return mCalendarViewCustom.getSelectedDate().getYear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getMonth() {
        try {
            if (mCalendarViewCustom != null) {
                return mCalendarViewCustom.getSelectedDate().getMonth() + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getDay() {
        try {
            if (mCalendarViewCustom != null) {
                return mCalendarViewCustom.getSelectedDate().getDay();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
