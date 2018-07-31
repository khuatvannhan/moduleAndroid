package com.nhankv.calendarlib.spinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nhankv.calendarlib.ListenerUp;
import com.nhankv.calendarlib.R;

@SuppressLint("AppCompatCustomView")
public class ImageViewArrowUp extends ImageView {
    private ListenerUp mListenerUp;

    public ImageViewArrowUp(Context context) {
        super(context);
        init(context);
    }

    public ImageViewArrowUp(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageViewArrowUp(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ImageViewArrowUp(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.setImageDrawable(context.getDrawable(R.drawable.ic_up));
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1.0f));
    }

    public void addEvent(ListenerUp listenerTimeChange) {
        mListenerUp = listenerTimeChange;
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListenerUp != null) {
                    mListenerUp.onClickUp();
                }
            }
        });
    }
}
