package com.mvvm.demo.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mvvm.demo.R;


/**
 * @author hzy
 */
public class TitleBarLayout extends LinearLayout {
    RelativeLayout titleBar;
    ImageView ivLeft;
    TextView tvLeft;
    TextView tvCenter;
    ImageView ivRight;
    TextView tvRight;
    View dividerView;

    public TitleBarLayout(Context context) {
        this(context, null);
    }

    public TitleBarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TitleBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleBarLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_title_bar, this);

        titleBar = findViewById(R.id.rl_actionbar);
        ivLeft = findViewById(R.id.iv_left);
        tvLeft = findViewById(R.id.tv_left);
        tvCenter = findViewById(R.id.tv_center);
        ivRight = findViewById(R.id.iv_right);
        tvRight = findViewById(R.id.tv_right);
        dividerView = findViewById(R.id.divider_view);
    }

    /**
     * 设置背景色
     */
    public void setTitleBarBackgroundColor(@ColorInt int color) {
        titleBar.setBackgroundColor(color);
    }

    public void setTitleBarBackground(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            titleBar.setBackground(drawable);
        } else {
            titleBar.setBackgroundDrawable(drawable);
        }
    }

    /**
     * 用来设置页面标题
     */
    public void setTitle(String title) {
        tvCenter.setText(title);
        tvCenter.setVisibility(View.VISIBLE);
    }

    public void setTitle(CharSequence text, TextView.BufferType type) {
        tvCenter.setText(text, type);
        tvCenter.setVisibility(View.VISIBLE);
    }

    public void setTitleColor(@ColorInt int color) {
        tvCenter.setTextColor(color);
    }

    /**
     * 设置左侧为正常返回键，常用
     */
    public void setLeftBack(OnClickListener onClickListener) {
        setLeftImage(R.mipmap.ic_common_back, onClickListener);
    }

    /**
     * 用于设置左侧图片按钮，如果是正常返回键使用setLeftBack()
     *
     * @param imgRes          imgRes
     * @param onClickListener onClickListenerlibsocketio.so
     */
    public void setLeftImage(int imgRes, OnClickListener onClickListener) {
        // 隐藏显示
        if (imgRes <= 0 && onClickListener == null) {
            ivRight.setImageBitmap(null);
            ivRight.setOnClickListener(null);
            ivRight.setVisibility(View.GONE);
        } else {
            ivLeft.setImageResource(imgRes);
            ivLeft.setOnClickListener(onClickListener);
            ivLeft.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置左侧为文本按钮
     *
     * @param btnText         btnText
     * @param onClickListener onClickListener
     */
    public void setLeftText(String btnText, OnClickListener onClickListener) {
        tvLeft.setText(btnText);
        tvLeft.setOnClickListener(onClickListener);
        tvLeft.setVisibility(View.VISIBLE);
    }

    public void setLeftTextColor(@ColorInt int color) {
        tvLeft.setTextColor(color);
    }

    /**
     * 设置右侧为图片按钮
     *
     * @param imgRes          imgRes
     * @param onClickListener onClickListener
     */
    public void setRightImage(int imgRes, OnClickListener onClickListener) {
        // 隐藏显示
        if (imgRes <= 0 && onClickListener == null) {
            ivRight.setImageBitmap(null);
            ivRight.setOnClickListener(null);
            ivRight.setVisibility(View.GONE);
        } else {
            ivRight.setImageResource(imgRes);
            ivRight.setOnClickListener(onClickListener);
            ivRight.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置右侧为文本按钮
     *
     * @param btnText         btnText
     * @param onClickListener onClickListener
     */
    public void setRightText(String btnText, OnClickListener onClickListener) {
        tvRight.setText(btnText);
        tvRight.setOnClickListener(onClickListener);
        tvRight.setVisibility(View.VISIBLE);
    }

    public void setRightTextColor(@ColorInt int color) {
        tvRight.setTextColor(color);
    }

    public void hideDividerView() {
        dividerView.setVisibility(GONE);
    }

}
