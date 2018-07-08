package com.example.wbcz.customcomponent;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {
    public ArrayList<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ActionBar bar = getSupportActionBar();
        if(bar != null) {
            bar.hide();
        }

        initFruit();

        RecyclerView reView = (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        reView.setLayoutManager(layoutManager);
        RecyleAdapter adapter = new RecyleAdapter(fruitList);
        reView.setAdapter(adapter);
    }


    public void initFruit() {
        for(int i = 0; i < 10; i++) {
            Fruit apple = new Fruit("苹果", R.mipmap.pp);
            Fruit banna = new Fruit("香蕉", R.mipmap.shui);
            fruitList.add(apple);
            fruitList.add(banna);
        }
    }
}
