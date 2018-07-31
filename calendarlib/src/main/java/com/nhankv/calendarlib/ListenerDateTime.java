package com.nhankv.calendarlib;

import android.os.Build;
import android.support.annotation.RequiresApi;

public interface ListenerDateTime {
    void onTimeSelected(int hour, int minute, int second);

    void onDateSelected(int day, int month, int year);
}
