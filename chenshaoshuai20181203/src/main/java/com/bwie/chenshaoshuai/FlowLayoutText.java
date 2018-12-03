package com.bwie.chenshaoshuai;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FlowLayoutText extends LinearLayout {
    private int mChildMaxHeight;
    private int mHSpace= 20;//左右的间距
    private int mVSpace = 20;//上下的间距



    public FlowLayoutText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);
        findMaxChildHeight();
        int left = 0, top =0;
        int childCount = getChildCount();
        for(int i = 0; i<getChildCount();i++){
            View view = getChildAt(i);
            if(left!=0){
                if((left+view.getMeasuredWidth())>sizeWidth){
                    top+= mChildMaxHeight+mVSpace;
                    left = 0;
                }
            }
            left += view.getMeasuredWidth() + mHSpace;
        }
        setMeasuredDimension(sizeWidth,(top + mChildMaxHeight)>sizeHeight? sizeHeight:top+mChildMaxHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildHeight();
        int left = 0,top=0;
        int childCount = getChildCount();
        for(int i =0;i<childCount;i++){
             View view = getChildAt(i);
             if(left!=0){
                 if((left+view.getMeasuredWidth())>getWidth()){
                    top+=mChildMaxHeight+mVSpace;
                    left = 0;
                 }
             }
             view.layout(left,top,left + view.getMeasuredWidth(),top+mChildMaxHeight);
             left+=view.getMeasuredWidth()+mHSpace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void findMaxChildHeight() {
        mChildMaxHeight = 0;
        int childCount = getChildCount();
        for(int i = 0; i<childCount;i++){
            View view = getChildAt(i);
            if(view.getMeasuredHeight() > mChildMaxHeight){
                mChildMaxHeight = view.getMeasuredHeight();
            }
        }
    }
}
