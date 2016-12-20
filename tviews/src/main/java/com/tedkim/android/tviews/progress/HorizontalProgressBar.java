package com.tedkim.android.tviews.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tedkim.android.tviews.R;

/**
 * Created by choebongjae on 2016. 11. 30..
 */

public class HorizontalProgressBar extends RelativeLayout {

    private ProgressBar progressBar;
    private TextView txt_progress;

    public HorizontalProgressBar(Context context) {
        super(context);
        init(context);

    }

    public HorizontalProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public HorizontalProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HorizontalProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View progressBarView = inflater.inflate(R.layout.view_horizontal_progress_bar_btn, null);
        addView(progressBarView);

        initView(progressBarView);

    }

    private void initView(View view) {
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        txt_progress = (TextView) view.findViewById(R.id.txt_progress);

        progressBar.setMax(100);
    }

    public ProgressBar getProgressbar() {
        return progressBar;
    }

    public void setProgress(int progress) {
        progressBar.setProgress(progress);
    }

    public TextView getTextView() {
        return txt_progress;
    }

    /**
     *
     * @param value default value is 100
     * @return
     */
    public HorizontalProgressBar setMaxProgress(int value){
        progressBar.setMax(value);
      return this;
    }
}
