package com.example.liujunyang.algorithmview.sort;

import android.util.Log;

public class SortController {
    public static void selectionSort(final SelectionSortView view) {
        new Thread() {
            @Override
            public void run() {
                int[] data = initData(10);
                int minIndex;
                for (int i = 0; i < data.length; i++) {
                    minIndex = i;
                    for (int j = i+1; j < data.length; j++) {
                        if (data[j] < data[minIndex]) {
                            minIndex = j;
                        }
                    }



                    Log.d("jun","最小值为："+data[minIndex]+" minIndex="+minIndex);
                    Log.d("jun",data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6]+" "+data[7]+" "+data[8]+" "+data[9]+" ");
                    view.setData(data,i,minIndex);
                    swap(data, i, minIndex);
//                    view.setData(data,i,minIndex);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }.start();
    }
    public static int[] initData(int n){
        Log.d("jun","initData");
        int[]data = new int[n];
        for(int i = 0; i<data.length;i++){
            data[i] =(int) (Math.random()*100);
            System.out.print(data[i]);
        }
        return data;

    }
    public static void swap(int[] data,int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
