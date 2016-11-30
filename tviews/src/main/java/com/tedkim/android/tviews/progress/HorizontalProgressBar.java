package com.tedkim.android.tviews.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.tedkim.android.tviews.R;

/**
 * Created by choebongjae on 2016. 11. 30..
 */

public class HorizontalProgressBar extends RelativeLayout {

    private ProgressBar progressBar;

    public HorizontalProgressBar(Context context) {
        super(context);
        initLayout(context);

    }

    public HorizontalProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);

    }

    public HorizontalProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HorizontalProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View progressBarView = inflater.inflate(R.layout.view_btn_progress_bar, null);
        addView(progressBarView);
        progressBar = (ProgressBar) progressBarView.findViewById(R.id.progressBar);

    }

    public ProgressBar getProgressbar() {
        return progressBar;
    }

    public void setProgress(int progress) {
        progressBar.setProgress(progress);
    }
}
