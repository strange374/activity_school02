package com.example.activity_school;
import org.jivesoftware.smack.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Connection;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activity_school.utils.ThreadUtils;
import com.example.activity_school.utils.ToastUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import static com.example.activity_school.R.id.et_username;

public class LoginActivity extends AppCompatActivity {
    private TextView etUSERNUMBER;
    private TextView etPASSWORD;

    private Button mBtnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListenner();
    }

    private void initListenner() {
        mBtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUSERNUMBER.getText().toString();
                final String password = etPASSWORD.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    etUSERNUMBER.setError("用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPASSWORD.setError("密码不能为空");
                    return;
                }
                ThreadUtils.runThread(new Runnable(){
                    public void run(){
                        try {
                        //创建连接配置对象
                        Connection confige = new ("192.168.1.100", 5222) ;

                        //主机IP，端口号

                        //开始创建连接对象
                        XmlPullParser connection = new XmlPullPaser(confige);
                        //开始连接
                        connection.connect();
                        //开始登录
                        connection.login(username,password);
                        //连接成功
                            ToastUtils.showToastSafe(LoginActivity.this,"登陆成功");
                            finish();
                            //调到主界面
                            Intent intent=new Intent(LoginActivity.this,Main2Activity.class)//主界面
                    }catch(XmlPullParserException e){
                        e.printStackTrace();
                            ToastUtils.showToastSafe(LoginActivity.this,"登陆失败");
                    }
                    }
                });


            }
        });
    }

    private void initView() {
        etUSERNUMBER = (TextView) findViewById(R.id.et_username);
        etPASSWORD = (TextView) findViewById(R.id.et_password);
        mBtnlogin = (Button) findViewById(R.id.btn_login);
    }


}
