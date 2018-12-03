package com.bwie.chenshaoshuai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class TitleView extends LinearLayout {
    Context mContext;
    public TitleView(Context context) {
        super(context);
        mContext = context;
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext,R.layout.title_name,null);
     }
}
