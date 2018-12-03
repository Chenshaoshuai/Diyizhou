package com.bwie.chenshaoshuai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TitleChildView extends LinearLayout {
    Context mContext;
    public TitleChildView(Context context) {
        super(context);
        mContext= context;
    }

    public TitleChildView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();

    }

    private void init() {
        View view = View.inflate(mContext,R.layout.title_child_name,null);
        final EditText editText = view.findViewById(R.id.edit_title);
        view.findViewById(R.id.search_title).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               if(mOnButtonListener !=null){
                   mOnButtonListener.OnButtonClick(editText.getText().toString());
               }
            }
        });
        addView(view);
    }
    OnButtonListener mOnButtonListener;

    public void setButtonListener(OnButtonListener onButtonListener) {
        this.mOnButtonListener = onButtonListener;
    }

    public interface OnButtonListener{
        void OnButtonClick(String str);
    }
}
