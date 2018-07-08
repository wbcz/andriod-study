package com.example.wbcz.customcomponent;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private String[] data = {"oringe", "apple","apple","apple","apple",
        "apple","apple","apple","apple","apple","apple","apple","apple","apple",
        "apple","apple","apple","apple","apple","apple","apple","apple","apple","apple" };


    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ActionBar bar = getSupportActionBar();
        if(bar != null) {
            bar.hide();
        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, data);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        initFruit();
        FruitAdapter adapter = new FruitAdapter(ListActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(ListActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
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
