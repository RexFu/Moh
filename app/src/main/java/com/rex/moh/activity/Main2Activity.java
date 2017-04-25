package com.rex.moh.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rex.moh.R;
import com.rex.moh.config.AlertUtils;

public class Main2Activity extends AppCompatActivity {

    private EditText mEditext;
    private TextView mSm;
    private ImageView mBack;
    private TextView mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mEditext=(EditText) findViewById(R.id.editText);
        mSm=(TextView) findViewById(R.id.tv_shming);
        mBack=(ImageView) findViewById(R.id.back);
        mStart=(TextView) findViewById(R.id.tv_start);
        initTouch();
    }
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            //要做的事情.
            AlertUtils.isDismiss();
            AlertUtils.ToastView(Main2Activity.this,"授权失败");
        }
    };
    private void initTouch() {
        mEditext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mSm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           AlertUtils.showCleanCache(Main2Activity.this,"");
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditext.getText())) {
                    AlertUtils.ToastView(Main2Activity.this,"密码不能为空");
                }else{
                    Sleep();
                }

            }
        });

    }

    private void Sleep() {
        AlertUtils.isShowLoad(Main2Activity.this);
        handler.postDelayed(runnable, 2000);

    }

}
