package com.example.preguntados;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullVideo extends VideoView {

    public FullVideo(Context context) {
        super(context);
    }

    public FullVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullVideo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
