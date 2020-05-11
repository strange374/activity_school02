package com.example.activity_school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.activity_school.utils.ThreadUtils;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //停留三秒进入主界面
        ThreadUtils.runThread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                Intent intent = new Intent(splashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
