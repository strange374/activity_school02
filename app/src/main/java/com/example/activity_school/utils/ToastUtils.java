package com.example.activity_school.utils;

import android.content.Context;
import android.widget.Toast;


public class ToastUtils {
    public static void showToastSafe(final Context context,final String text){
        ThreadUtils.runUIThread(new Runnable(){
            public  void run(){
                Toast.makeText(context,text,Toast.LENGTH_SHORT ).show();
            }

        });
    }
}
