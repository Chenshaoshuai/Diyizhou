package com.bwie.chenshaoshuai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TextViewName extends TextView {

    public TextViewName(Context context) {
        super(context);
    }

    public TextViewName(Context context,  AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.FlowLayoutText);
        int color =typedArray.getColor(R.styleable.FlowLayoutText_textColor,Color.BLACK);
        setTextColor(color);
        typedArray.recycle();
    }
}
