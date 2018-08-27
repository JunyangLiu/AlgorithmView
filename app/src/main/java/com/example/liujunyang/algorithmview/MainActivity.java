package com.example.liujunyang.algorithmview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.liujunyang.algorithmview.probability.CustomView1;
import com.example.liujunyang.algorithmview.probability.MonteCarloView;
import com.example.liujunyang.algorithmview.sort.SelectionSortView;
import com.example.liujunyang.algorithmview.sort.SortController;

public class MainActivity extends AppCompatActivity {
    private CustomView1 customView1;
    private MonteCarloView monteCarloView;
    private SelectionSortView selectionSortView;
    private int[] data = new int[100];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        for (int i = 0; i < data.length; i++) {
            data[i] = 100;
        }
//        customView1.setData(data);
//        ViewController.action1(data,customView1);


    }

    private void initView() {
//        customView1 = findViewById(R.id.cv);
//        monteCarloView = findViewById(R.id.mc_view);
        selectionSortView = findViewById(R.id.select_sort_view) ;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        ViewController.monterCarlo(monteCarloView);
        SortController.selectionSort(selectionSortView);
    }
}


