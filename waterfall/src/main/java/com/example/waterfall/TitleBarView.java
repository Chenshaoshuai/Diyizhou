package com.example.waterfall;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TitleBarView extends LinearLayout {
    Context mContext;
    public TitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    private void init() {
        View view = View.inflate(mContext,R.layout.title,null);
        final EditText editText = view.findViewById(R.id.edit_title);
        view.findViewById(R.id.search_title).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              if(mOnBuutonClickListener != null){
                  mOnBuutonClickListener.onBuutonClick(editText.getText().toString());
              }
            }
        });
        addView(view);
    }
    OnBuutonClickListener mOnBuutonClickListener;

    public void setButtonClickListener(OnBuutonClickListener onBuutonClickListener) {
        this.mOnBuutonClickListener = onBuutonClickListener;

    }



    public interface OnBuutonClickListener{
        void onBuutonClick(String str);
    }

}
