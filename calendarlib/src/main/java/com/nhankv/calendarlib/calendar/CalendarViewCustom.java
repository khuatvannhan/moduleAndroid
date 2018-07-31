package com.nhankv.calendarlib.calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nhankv.calendarlib.ListenerDateTime;
import com.nhankv.calendarlib.R;
import com.nhankv.calendarlib.datetime.LinearLayoutDateTime;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

public class CalendarViewCustom extends MaterialCalendarView {
    private final String TAG = getClass().getName();
    private ListenerDateTime mListenerDateTime;

    public CalendarViewCustom(Context context) {
        super(context);
        init(context);
    }

    public CalendarViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        initView(context);
        addEvent();
        Calendar calendar = Calendar.getInstance();
        setCurrentDate(calendar);
        setSelected(true);
        setSelectedDate(calendar);
    }

    private void initView(Context context) {
        setTileWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setDateTextAppearance(R.style.TitleTheme);
        setHeaderTextAppearance(R.style.TitleTheme);
        setWeekDayTextAppearance(R.style.WeekTheme);
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 5.0f));
    }

    private void addEvent() {
        setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView materialCalendarView, @NonNull CalendarDay calendarDay, boolean b) {
                Log.d(TAG, " OnClickDate, date " + calendarDay.getDate() + " day "
                        + calendarDay.getDay() + " month " + calendarDay.getMonth() + " year " +
                        calendarDay.getYear());
                if (mListenerDateTime != null) {
                    mListenerDateTime.onDateSelected(calendarDay.getDay(), calendarDay.getMonth() + 1,
                            calendarDay.getYear());
                }
            }
        });
    }

    public void setOnClickListenerDateTime(ListenerDateTime linearLayoutDateTime) {
        mListenerDateTime = linearLayoutDateTime;
    }
}
