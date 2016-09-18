package com.tedkim.android.tviews.dialog;

import android.app.Dialog;
import android.content.Context;

import com.tedkim.android.tviews.R;

/**
 * Created by Ted
 */
public class ProgressBarDialog extends Dialog {

    private static ProgressBarDialog mInstance;
    private Context mContext;

    public static ProgressBarDialog getInstance(Context context) {
//        if (mInstance == null) {
            mInstance = new ProgressBarDialog(context);
//        }
        mInstance.mContext = context;
        return mInstance;
    }

    public ProgressBarDialog(Context context) {
        super(context, R.style.MaterialDialog);
        setCanceledOnTouchOutside(false);
        initLayout();
    }

    private void initLayout() {
        setContentView(R.layout.dialog_progress_bar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
