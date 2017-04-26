package com.tedkim.android.tviews.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tedkim.android.tviews.R;
import com.tedkim.android.tviews.interfaces.OnCustomToolBarListener;
import com.tedkim.android.tviews.utils.ViewUtils;

/**
 * Custom toolbar class
 * Created by Ted
 */
public class TToolBar extends RelativeLayout {

    private Context mContext;

    private RelativeLayout layoutToolbar;

    private ImageView imgLeftItem;
    private ImageView imgRightItem;

    private TextView textTitle;
    private TextView textLeftItem;
    private TextView textRightItem;

    private ImageView imgTitle;

    private OnCustomToolBarListener mOnCustomToolBarListener;

    public TToolBar(Context context) {
        super(context);
        initCustomToolBar(context);
    }

    public TToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCustomToolBar(context);
    }

    private void initCustomToolBar(Context context) {
        this.mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_tool_bar, null);
        addView(view);

        initLayout(view);
    }

    private void initLayout(View v) {
        layoutToolbar = (RelativeLayout) v.findViewById(R.id.layoutToolbar);

        imgLeftItem = (ImageView) v.findViewById(R.id.imgLeftItem);
        imgRightItem = (ImageView) v.findViewById(R.id.imgRightItem);

        textTitle = (TextView) v.findViewById(R.id.textTitle);
        textLeftItem = (TextView) v.findViewById(R.id.textLeftItem);
        textRightItem = (TextView) v.findViewById(R.id.textRightItem);


        //Adel, 2016-08-26
        imgTitle = (ImageView) v.findViewById(R.id.imgTitle);
        imgTitle.setVisibility(View.GONE);

        imgLeftItem.setOnClickListener(mOnClickListener);
        imgRightItem.setOnClickListener(mOnClickListener);
        textLeftItem.setOnClickListener(mOnClickListener);
        textRightItem.setOnClickListener(mOnClickListener);
    }

    //==== Toolbar =======================================================================================//

    /**
     * set toolbar background
     *
     * @param color color
     * @return CustomToolBar
     */
    public TToolBar setToolbarBackground(int color) {
        layoutToolbar.setBackgroundColor(color);
        return this;
    }

    //==== Title =======================================================================================//

    /**
     * Set title text
     *
     * @param text title
     * @return CustomToolBar
     */
    public TToolBar setTitleText(String text) {
        //Adel, 2016-08-26
        imgTitle.setVisibility(View.GONE);
        textTitle.setVisibility(View.VISIBLE);

        textTitle.setText(text);
        return this;
    }

    /**
     * Set title text color
     *
     * @param color title color
     * @return v
     */
    public TToolBar setTitleColor(int color) {
        textTitle.setTextColor(color);
        return this;
    }

    /**
     * Set title text size
     *
     * @param dp text size
     * @return CustomToolBar
     */
    public TToolBar setTitleSize(float dp) {
        textTitle.setTextSize(ViewUtils.convertDpToPixels(mContext, dp));
        return this;
    }

    //Adel, 2016-08-25
    /**
     * Set title text image resid
     *
     * @param image title image resource
     * @param width title image width(dp)
     * @param height title image height(dp)
     * @return CustomToolBar
     */
    public TToolBar setTitleImage(int image, float width, float height) {
        textTitle.setVisibility(View.GONE);
        imgTitle.setVisibility(View.VISIBLE);

        imgTitle.setImageResource(image);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)imgTitle.getLayoutParams();
        params.width = (int)width;
        params.height = (int)height;
        imgTitle.setLayoutParams(params);
        return this;
    }

    //Adel, 2016-08-31
    /**
     * Hide title
     *
     * @return CustomToolBar
     */
    public TToolBar setHideTitle() {
        textTitle.setVisibility(INVISIBLE);
        imgTitle.setVisibility(INVISIBLE);
        return this;
    }

    //==== Left Button =======================================================================================//

    /**
     * Set left image item
     *
     * @param image image resid
     * @return CustomToolBar
     */
    public TToolBar setLeftImageItem(int image) {
        imgLeftItem.setVisibility(View.VISIBLE);
        textLeftItem.setVisibility(View.INVISIBLE);
        imgLeftItem.setBackgroundResource(image);
        return this;
    }

    /**
     * Set left text item
     *
     * @param text text
     * @return CustomToolBar
     */
    public TToolBar setLeftTextItem(String text) {
        textLeftItem.setVisibility(View.VISIBLE);
        imgLeftItem.setVisibility(View.INVISIBLE);
        textLeftItem.setText(text);
        return this;
    }

    /**
     * Set left text color
     *
     * @param color text color
     * @return CustomToolBar
     */
    public TToolBar setLeftTextColor(int color) {
        textLeftItem.setTextColor(color);
        return this;
    }

    /**
     * Set left text size
     *
     * @param dp dp size
     * @return CustomToolBar
     */
    public TToolBar setLeftTextSize(int dp) {
        textLeftItem.setTextSize(ViewUtils.convertDpToPixels(mContext, dp));
        return this;
    }

    /**
     * Set left item back button
     *
     * @return CustomToolBar
     */
    public TToolBar setLeftBackButton() {
        textLeftItem.setVisibility(INVISIBLE);
        imgLeftItem.setBackgroundResource(R.drawable.ic_arrow_left_white);
        return this;
    }

    /**
     * Hide left item
     *
     * @return CustomToolBar
     */
    public TToolBar setHideLeftButton() {
        textLeftItem.setVisibility(INVISIBLE);
        imgLeftItem.setVisibility(INVISIBLE);
        return this;
    }

    //==== Right Button =======================================================================================//

    /**
     * Set right image item
     *
     * @param image image resid
     * @return CustomToolBar
     */
    public TToolBar setRightImageItem(int image) {
        imgRightItem.setVisibility(View.VISIBLE);
        textRightItem.setVisibility(View.INVISIBLE);
        imgRightItem.setBackgroundResource(image);
        return this;
    }

    /**
     * Set right text item
     *
     * @param text text
     * @return CustomToolBar
     */
    public TToolBar setRightTextItem(String text) {
        textRightItem.setVisibility(View.VISIBLE);
        imgRightItem.setVisibility(View.INVISIBLE);
        textRightItem.setText(text);
        return this;
    }

    /**
     * Set right text color
     *
     * @param color text color
     * @return CustomToolBar
     */
    public TToolBar setRightTextColor(int color) {
        textRightItem.setTextColor(color);
        return this;
    }

    /**
     * Set right text size
     *
     * @param dp dp size
     * @return CustomToolBar
     */
    public TToolBar setRightTextSize(int dp) {
        textRightItem.setTextSize(ViewUtils.convertDpToPixels(mContext, dp));
        return this;
    }

    /**
     * Hide left item
     *
     * @return CustomToolBar
     */
    public TToolBar setHideRightButton() {
        textRightItem.setVisibility(INVISIBLE);
        imgRightItem.setVisibility(INVISIBLE);
        return this;
    }

    /**
     * Custom Toolbar build
     */
    public void build() {
        setTitleLayoutParams();
    }

    private void setTitleLayoutParams() {
        RelativeLayout.LayoutParams params = (LayoutParams) textTitle.getLayoutParams();

        // set left item
        if (imgLeftItem.getVisibility() == View.VISIBLE
                || textLeftItem.getVisibility() == View.VISIBLE) {
            if (imgLeftItem.getVisibility() == View.VISIBLE)
                params.addRule(RelativeLayout.RIGHT_OF, R.id.imgLeftItem);
            else
                params.addRule(RelativeLayout.RIGHT_OF, R.id.textLeftItem);
        }

        // set right item
        if (imgRightItem.getVisibility() == View.VISIBLE
                || textRightItem.getVisibility() == View.VISIBLE) {
            if (imgRightItem.getVisibility() == View.VISIBLE)
                params.addRule(RelativeLayout.LEFT_OF, R.id.imgRightItem);
            else
                params.addRule(RelativeLayout.LEFT_OF, R.id.textRightItem);
        }
    }

    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = v.getId();
            if (i == R.id.imgLeftItem || i == R.id.textLeftItem) {
                if (mOnCustomToolBarListener != null)
                    mOnCustomToolBarListener.onClickLeftItem();
            } else if (i == R.id.imgRightItem || i == R.id.textRightItem) {
                if (mOnCustomToolBarListener != null)
                    mOnCustomToolBarListener.onClickRightItem();
            }
        }
    };

    public void setOnToolBarListener(OnCustomToolBarListener onCustomToolBarListener) {
        this.mOnCustomToolBarListener = onCustomToolBarListener;
    }
}
