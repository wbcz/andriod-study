package com.example.wbcz.customcomponent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        if(bar != null) {
            bar.hide();
        }

        Button call = (Button) findViewById(R.id.call);
        Button sendData = (Button) findViewById(R.id.sendData);
        Button returnData = (Button) findViewById(R.id.returnData);
        Button listView = (Button) findViewById(R.id.listView);
        Button recycleView = (Button) findViewById(R.id.recycleView);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示intent调用
                //Intent intent  = new Intent(MainActivity.this, SecondActivity.class);
                //隐式调用
                //Intent intent  = new Intent("com.example.wbcz.customcomponent.ACTION_TT");
                //其他隐式调用
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("toSecond", "hello boy");
                startActivity(intent);
            }
        });

        //返回上个页面的数据
        returnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }

        });

        recycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecycleActivity.class);
                startActivity(intent);
            }

        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String data1 = data.getStringExtra("return_data");
                    Toast.makeText(this, data1, Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
