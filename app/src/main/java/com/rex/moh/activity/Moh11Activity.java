package com.rex.moh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rex.moh.R;
import com.rex.moh.config.AlertUtils;

public class Moh11Activity extends AppCompatActivity {

    private TextView mStart;
    private TextView mSq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh11);
        mStart=(TextView) findViewById(R.id.tv_sart);
        mSq=(TextView) findViewById(R.id.tv_sq);
        mSq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Moh11Activity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertUtils.ToastView(Moh11Activity.this,"充值失败请联系在线客服");
            }
        });
    }
}
