package com.example.liujunyang.algorithmview.sort;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SelectionSortView extends View{
    private int[] data;
    private int width;
    private int height;
    private int sortIndex = -1;
    private int minIndex = 0;
    private Paint paint;

    public void setData(int[] data,int sortIndex,int minIndex){
        this.data = data;
        this.sortIndex = sortIndex;
        this.minIndex = minIndex;
        Log.d("jun","view setData");
        invalidate();
    }
    public SelectionSortView(Context context) {
        super(context);
    }

    public SelectionSortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionSortView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        height=MeasureSpec.getSize(heightMeasureSpec);
//        Log.d("jun","width = "+width+" height = "+height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setStyle(Paint.Style.FILL);


        if(data!=null&&data.length>0){
            int barWidth = width/data.length;
//            Log.d("jun","【barWidth = "+barWidth+"】  ");
            for(int i=0;i<data.length;i++){
                if(i<sortIndex){
                    paint.setColor(Color.RED);
                }else if(i == minIndex){
                    paint.setColor(Color.YELLOW);
                }else{
                    paint.setColor(Color.BLUE);
                }

                canvas.drawRect(barWidth*i,height-50-data[i],barWidth*(i+1)-5,height-50,paint);

//                paint.setTextSize(barWidth/2);
//                canvas.drawText(data[i]+"",barWidth*i+5,height-52-data[i],paint);
//                Log.d("jun",(barWidth*i)+"  "+(height-50-data[i])+"  "+(barWidth*(i+1)-2)+" " +(height-50));
            }

        }
    }
}
