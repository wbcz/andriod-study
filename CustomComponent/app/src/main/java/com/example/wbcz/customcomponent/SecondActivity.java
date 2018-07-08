package com.example.wbcz.customcomponent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar bar = getSupportActionBar();
        if(bar != null) {
            bar.hide();
        }

        //获取上个活动传递的数据
        Intent intent = getIntent();
        String data = intent.getStringExtra("toSecond");
        if(data != null) {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        //返回数据给上个活动
        Intent intent1 = new Intent();
        intent1.putExtra("return_data", "hi, girl, Im back");
        setResult(RESULT_OK, intent1);
        finish();
    }

}
