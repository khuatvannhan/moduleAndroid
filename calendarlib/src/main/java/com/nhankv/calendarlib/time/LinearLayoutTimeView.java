package com.nhankv.calendarlib.time;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nhankv.calendarlib.ListenerDateTime;
import com.nhankv.calendarlib.ListenerDown;
import com.nhankv.calendarlib.ListenerUp;
import com.nhankv.calendarlib.R;
import com.nhankv.calendarlib.datetime.LinearLayoutDateTime;
import com.nhankv.calendarlib.spinner.ImageViewArrowDown;
import com.nhankv.calendarlib.spinner.ImageViewArrowUp;
import com.nhankv.calendarlib.spinner.LinearLayoutSpinner;
import com.nhankv.calendarlib.spinner.TextViewNumber;

import java.util.Calendar;

import static android.view.Gravity.CENTER_VERTICAL;

public class LinearLayoutTimeView extends LinearLayout {
    private ListenerDateTime mListenerDateTime;
    private TextViewNumber mTextViewNumberHour;
    private TextViewNumber mTextViewNumberMinute;
    private TextViewNumber mTextViewNumberSecond;

    private ImageViewArrowUp mImageViewArrowHourUp;
    private ImageViewArrowUp mImageViewArrowMinuteUp;
    private ImageViewArrowUp mImageViewArrowSecondUp;
    private ImageViewArrowDown mImageViewArrowHourDown;
    private ImageViewArrowDown mImageViewArrowMinuteDown;
    private ImageViewArrowDown mImageViewArrowSecondDown;

    private LinearLayoutSpinner mLayoutSpinnerHour;
    private LinearLayoutSpinner mLayoutSpinnerMinute;
    private LinearLayoutSpinner mLayoutSpinnerSecond;

    public LinearLayoutTimeView(Context context) {
        super(context);
        init(context);
    }

    public LinearLayoutTimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LinearLayoutTimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        initView(context);
        addView(context);
        initViewChild(context);
        addEvent();
    }

    private void initView(Context context) {
        setWeightSum(3);
        setPadding(10, 0, 30, 10);
        setOrientation(HORIZONTAL);
        setGravity(CENTER_VERTICAL);
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f));
    }

    private void addView(Context context) {
        mLayoutSpinnerHour = new LinearLayoutSpinner(context);
        mLayoutSpinnerMinute = new LinearLayoutSpinner(context);
        mLayoutSpinnerSecond = new LinearLayoutSpinner(context);
        addView(mLayoutSpinnerHour);
        addView(mLayoutSpinnerMinute);
        addView(mLayoutSpinnerSecond);
    }

    private void initViewChild(Context context) {
        try {
            mLayoutSpinnerHour.getmTxtTitle().setText(context.getResources().getString(R.string.hour));
            mLayoutSpinnerMinute.getmTxtTitle().setText(context.getResources().getString(R.string.minute));
            mLayoutSpinnerSecond.getmTxtTitle().setText(context.getResources().getString(R.string.second));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mTextViewNumberHour = mLayoutSpinnerHour.getmLinearLayoutNumber().getmTxtNumber();
            mTextViewNumberMinute = mLayoutSpinnerMinute.getmLinearLayoutNumber().getmTxtNumber();
            mTextViewNumberSecond = mLayoutSpinnerSecond.getmLinearLayoutNumber().getmTxtNumber();

            mImageViewArrowHourUp = mLayoutSpinnerHour.getmLinearLayoutNumber().
                    getmLinearLayoutArrow().getmImageViewArrowUp();
            mImageViewArrowMinuteUp = mLayoutSpinnerMinute.getmLinearLayoutNumber().
                    getmLinearLayoutArrow().getmImageViewArrowUp();
            mImageViewArrowSecondUp = mLayoutSpinnerSecond.getmLinearLayoutNumber().
                    getmLinearLayoutArrow().getmImageViewArrowUp();

            mImageViewArrowHourDown = mLayoutSpinnerHour.getmLinearLayoutNumber().
                    getmLinearLayoutArrow().getmImageViewArrowDown();
            mImageViewArrowMinuteDown = mLayoutSpinnerMinute.getmLinearLayoutNumber().
                    getmLinearLayoutArrow().getmImageViewArrowDown();
            mImageViewArrowSecondDown = mLayoutSpinnerSecond.getmLinearLayoutNumber().
                    getmLinearLayoutArrow().getmImageViewArrowDown();

            Calendar calendar = Calendar.getInstance();
            int mIndexHour = calendar.get(Calendar.SECOND);
            int mIndexMinute = calendar.get(Calendar.HOUR_OF_DAY);
            int mIndexSecond = calendar.get(Calendar.MINUTE);
            mTextViewNumberSecond.setText(String.valueOf(mIndexHour));
            mTextViewNumberHour.setText(String.valueOf(mIndexMinute));
            mTextViewNumberMinute.setText(String.valueOf(mIndexSecond));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEvent() {
        mImageViewArrowHourUp.addEvent(new ListenerUp() {
            @Override
            public void onClickUp() {
                int mIndexHour = Integer.parseInt(mTextViewNumberHour.getText().toString());
                if (mIndexHour < 23) {
                    mIndexHour++;
                }
                if (mIndexHour == 23) {
                    mIndexHour = 0;
                }
                mTextViewNumberHour.setText(String.valueOf(mIndexHour));
                onTimeChange();
            }
        });

        mImageViewArrowMinuteUp.addEvent(new ListenerUp() {
            @Override
            public void onClickUp() {
                int mIndexMinute = Integer.parseInt(mTextViewNumberMinute.getText().toString());
                if (mIndexMinute < 59) {
                    mIndexMinute++;
                }
                if (mIndexMinute == 59) {
                    mIndexMinute = 0;
                }
                mTextViewNumberMinute.setText(String.valueOf(mIndexMinute));
                onTimeChange();
            }
        });

        mImageViewArrowSecondUp.addEvent(new ListenerUp() {
            @Override
            public void onClickUp() {
                int mIndexSecond = Integer.parseInt(mTextViewNumberSecond.getText().toString());
                if (mIndexSecond < 59) {
                    mIndexSecond++;
                }
                if (mIndexSecond == 59) {
                    mIndexSecond = 0;
                }
                mTextViewNumberSecond.setText(String.valueOf(mIndexSecond));
                onTimeChange();
            }
        });

        mImageViewArrowHourDown.addEvent(new ListenerDown() {
            @Override
            public void onClickDown() {
                int mIndexHour = Integer.parseInt(mTextViewNumberHour.getText().toString());
                if (mIndexHour > 0) {
                    mIndexHour--;
                }
                if (mIndexHour == 0) {
                    mIndexHour = 23;
                }
                mTextViewNumberHour.setText(String.valueOf(mIndexHour));
                onTimeChange();
            }
        });

        mImageViewArrowMinuteDown.addEvent(new ListenerDown() {
            @Override
            public void onClickDown() {
                int mIndexMinute = Integer.parseInt(mTextViewNumberMinute.getText().toString());
                if (mIndexMinute > 0) {
                    mIndexMinute--;
                }
                if (mIndexMinute == 0) {
                    mIndexMinute = 59;
                }
                mTextViewNumberMinute.setText(String.valueOf(mIndexMinute));
                onTimeChange();
            }
        });

        mImageViewArrowSecondDown.addEvent(new ListenerDown() {
            @Override
            public void onClickDown() {
                int mIndexSecond = Integer.parseInt(mTextViewNumberSecond.getText().toString());
                if (mIndexSecond > 0) {
                    mIndexSecond--;
                }
                if (mIndexSecond == 0) {
                    mIndexSecond = 59;
                }
                mTextViewNumberSecond.setText(String.valueOf(mIndexSecond));
                onTimeChange();
            }
        });
    }

    public LinearLayoutSpinner getmLayoutSpinnerHour() {
        return mLayoutSpinnerHour;
    }

    public void setmLayoutSpinnerHour(LinearLayoutSpinner mLayoutSpinnerHour) {
        this.mLayoutSpinnerHour = mLayoutSpinnerHour;
    }

    public LinearLayoutSpinner getmLayoutSpinnerMinute() {
        return mLayoutSpinnerMinute;
    }

    public void setmLayoutSpinnerMinute(LinearLayoutSpinner mLayoutSpinnerMinute) {
        this.mLayoutSpinnerMinute = mLayoutSpinnerMinute;
    }

    public LinearLayoutSpinner getmLayoutSpinnerSecond() {
        return mLayoutSpinnerSecond;
    }

    public void setmLayoutSpinnerSecond(LinearLayoutSpinner mLayoutSpinnerSecond) {
        this.mLayoutSpinnerSecond = mLayoutSpinnerSecond;
    }

    public void setOnClickListenerDateTime(ListenerDateTime linearLayoutDateTime) {
        mListenerDateTime = linearLayoutDateTime;
    }

    private void onTimeChange() {
        try {
            int hour = Integer.parseInt(mTextViewNumberHour.getText().toString());
            int minute = Integer.parseInt(mTextViewNumberMinute.getText().toString());
            int second = Integer.parseInt(mTextViewNumberSecond.getText().toString());
            mListenerDateTime.onTimeSelected(hour, minute, second);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getmIndexHour() {
        return Integer.parseInt(mTextViewNumberHour.getText().toString());
    }

    public void setmIndexHour(int mIndexHour) {
        mTextViewNumberHour.setText(String.valueOf(mIndexHour));
    }

    public int getmIndexMinute() {
        return Integer.parseInt(mTextViewNumberMinute.getText().toString());
    }

    public void setmIndexMinute(int mIndexMinute) {
        mTextViewNumberMinute.setText(String.valueOf(mIndexMinute));
    }

    public int getmIndexSecond() {
        return Integer.parseInt(mTextViewNumberSecond.getText().toString());
    }

    public void setmIndexSecond(int mIndexSecond) {
        mTextViewNumberSecond.setText(String.valueOf(mIndexSecond));
    }
}
