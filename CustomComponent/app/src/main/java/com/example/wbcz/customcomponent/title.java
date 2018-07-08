package com.example.wbcz.customcomponent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.example.wbcz.customcomponent.R.*;

public class title extends LinearLayout {
    public title(Context context, AttributeSet attrs){
        super(context, attrs);
        //inflate动态加载文件
        LayoutInflater.from(context).inflate(layout.title, this);
        Button back = (Button) findViewById(id.back);
        Button edit = (Button) findViewById(id.edit);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tes", "onClick:ttttttt ");
                ((Activity) getContext()).finish();
            }
        });

        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "edit",  Toast.LENGTH_SHORT).show();
            }
        });

        
    }

}
