package com.example.waterfall;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class WeekFlowLayout extends LinearLayout {
    //孩子中最高的一个
     private int mChildMaxHeight;
     //每一行上下的默认间距
     private int mVSpace =20;
     //每一个孩子的左右间距
     private int mHSpace =20;

    public WeekFlowLayout(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //拿到父容器推荐的宽和高以及计算模式
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        //测量孩子的大小，必须写
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //找到孩子中最高的，找到会放到mChildMaxHeight变量中
        findMaxChildMaxHeight();
        //初始化值
        int left = 0,top = 0;
        //循环所有的孩子
        int childCount = getChildCount();
        for(int i =0;i<childCount;i++){
            View view = getChildAt(i);
            //是否是一行的开头
            if(left != 0){
              if((left+view.getMeasuredWidth()>sizeWidth)){
                  top += mChildMaxHeight+mVSpace;
                  left = 0;
              }
            }
            left+= view.getMeasuredWidth()+mHSpace;
        }
        setMeasuredDimension(sizeWidth,(top+mChildMaxHeight)>sizeHeight ? sizeHeight:top + mChildMaxHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildMaxHeight();
        int left = 0, top = 0;
        int childCount = getChildCount();
        for(int i =0;i<childCount;i++){
            View view = getChildAt(i);
            if(left!= 0){
              if((left+view.getMeasuredWidth())>getWidth()){
                  top+=mChildMaxHeight+mVSpace;
                  left = 0;
              }
            }
            view.layout(left,top,left+view.getMeasuredWidth(),top+mChildMaxHeight);
            left+=view.getMeasuredWidth()+mHSpace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void findMaxChildMaxHeight() {
     mChildMaxHeight = 0;
     int childCount = getChildCount();
     for(int i =0;i<childCount;i++){
           View view = getChildAt(i);
           if(view.getMeasuredHeight() > mChildMaxHeight){
              mChildMaxHeight = view.getMeasuredHeight();
           }
     }
    }
}
