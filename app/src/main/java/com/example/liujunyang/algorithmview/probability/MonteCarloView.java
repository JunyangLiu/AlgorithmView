package com.example.liujunyang.algorithmview.probability;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.liujunyang.algorithmview.probability.model.Circle;
import com.example.liujunyang.algorithmview.probability.model.Point;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 使用蒙特卡洛算法求π值
 */
public class MonteCarloView extends View{
    private List<Point> points;
    public int width;
    public int height;
    private Paint paint;
    private int circleArea = 0;
    private int suquareArea=0;

    private Circle circle;
    public void addData(Point point){
        points.add(point);
        if(null!=circle&&circle.contain(point)){
            circleArea++;
            suquareArea = points.size();
            Log.d("jun","【 π = "+(double)circleArea/suquareArea*4);
            Log.d("jun"," circleArea = "+circleArea+"suquareArea = "+suquareArea);
        }
        invalidate();
    }
    public MonteCarloView(Context context) {
        super(context);
    }

    public MonteCarloView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        points = new CopyOnWriteArrayList<>();
    }

    public MonteCarloView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        int r= width/2-10;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        circle = new Circle(width/2,height/2,r);
        paint.setColor(Color.RED);
        canvas.drawCircle(circle.getX(),circle.getY(),circle.getR(),paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(width/2-r,height/2-r,width/2+r,height/2+r,paint);

        if(points!=null){

            for(Point p:points){
                if(circle.contain(p)){
                    paint.setColor(Color.RED);

                }else{
                    paint.setColor(Color.BLUE);
                }
                canvas.drawPoint(p.getX(),p.getY(),paint);
            }
        }




    }
}
