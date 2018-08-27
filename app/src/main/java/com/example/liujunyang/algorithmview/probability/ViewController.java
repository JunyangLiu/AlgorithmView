package com.example.liujunyang.algorithmview.probability;

import android.util.Log;

import com.example.liujunyang.algorithmview.probability.model.Point;

import java.util.Arrays;

public class ViewController {
    /**
     * 分钱问题
     * @param data
     * @param view
     */
    public static void action1(final int[] data,final CustomView1 view){
        new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){

                    for(int i = 0;i < data.length;i++){
                        int j = (int) (Math.random()*data.length);
                        if(data[i]>0){
                            data[j]+=1;
                            data[i]-=1;
                        }
                    }
                    Arrays.sort(data);
                    view.setData(data);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    /**
     * 蒙特卡洛算法
     * @param monteCarloView
     */
    public static void monterCarlo(final MonteCarloView monteCarloView) {
        new Thread() {
            @Override
            public void run() {
                int h = monteCarloView.height;
                int w = monteCarloView.width;

                int r = w / 2 - 10;
                Log.d("jun", " 看这里！！！ 【 w=" + w + "  h=" + h+" 】 r ="+r);
                for (int i = 0; i < 20000; i++) {

                    int x = (int) (Math.random() * 2 * r + 5);
                    int y = (int) (Math.random() * 2 * r + (h / 2) - r);
                    Point point = new Point(x, y);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    monteCarloView.addData(point);
                }

            }
        }.start();
    }
}
