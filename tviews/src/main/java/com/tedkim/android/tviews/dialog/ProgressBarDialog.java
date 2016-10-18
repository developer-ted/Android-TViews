package com.tedkim.android.tviews.dialog;

import android.app.Dialog;
import android.content.Context;

import com.tedkim.android.tviews.R;

/**
 * Created by Ted
 */
public class ProgressBarDialog extends Dialog {

    public static ProgressBarDialog getInstance(Context context) {
        return new ProgressBarDialog(context);
    }

    private ProgressBarDialog(Context context) {
        super(context, R.style.MaterialDialog);
        setCanceledOnTouchOutside(false);
        initLayout();
    }

    private void initLayout() {
        setContentView(R.layout.dialog_progress_bar);
    }

    /**
     * start loading
     */
    public void startLoading() {
        show();
    }

    /**
     * stop loading
     */
    public void stopLoading() {
        dismiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
