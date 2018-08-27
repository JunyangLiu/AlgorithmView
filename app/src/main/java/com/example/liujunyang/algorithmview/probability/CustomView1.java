package com.example.liujunyang.algorithmview.probability;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView1 extends View {
    private int[] data;
    private int width;
    private int height;
    private Paint paint;
    public void setData(int[] data){
        this.data = data;
        invalidate();
    }
    public CustomView1(Context context) {
        super(context);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=MeasureSpec.getSize(widthMeasureSpec);
        height=MeasureSpec.getSize(heightMeasureSpec);
        Log.d("jun","width = "+width+" height = "+height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);


        if(data!=null&&data.length>0){
            int barWidth = width/data.length;
            Log.d("jun","【barWidth = "+barWidth+"】  ");
            for(int i=0;i<data.length;i++){
                canvas.drawRect(barWidth*i,height-50-data[i],barWidth*(i+1)-2,height-50,paint);
//                Log.d("jun","top = "+(height-data[i])+" height = "+height);
            }

        }
    }
}
