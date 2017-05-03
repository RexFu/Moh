package com.rex.moh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rex.moh.R;
import com.rex.moh.bean.Mohbean;
import com.rex.moh.config.AlertUtils;
import com.rex.moh.config.Call;
import com.rex.moh.config.NetWork;
import com.rex.moh.config.ProRes;
import com.rex.moh.listener.Callss;
import com.rex.moh.view.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Moh5Activity extends AppCompatActivity {

    private TextView mChose;
    private EditText mEditext;
    private ToggleButton mBut1;
    private ToggleButton mBut2;
    private ToggleButton mBut3;
    private ToggleButton mBut4;
    private ToggleButton mBut5;
    private ToggleButton mBut6;
    private TextView mStart;
    private TextView mSq;
    private Intent mIntent;
    private Mohbean mMohBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initView();
        initTouch();
        mIntent=getIntent();
        mMohBean= (Mohbean) mIntent.getSerializableExtra("user");
        mChose.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
    }

    private void initView() {
        mChose = (TextView) findViewById(R.id.tv_xzlx);
        mEditext = (EditText) findViewById(R.id.editText);
        mBut1 = (ToggleButton) findViewById(R.id.bv_btn1);
        mBut2 = (ToggleButton) findViewById(R.id.bv_btn2);
        mBut3 = (ToggleButton) findViewById(R.id.bv_btn3);
        mBut4 = (ToggleButton) findViewById(R.id.bv_btn4);
        mBut5 = (ToggleButton) findViewById(R.id.bv_btn5);
        mBut6 = (ToggleButton) findViewById(R.id.bv_btn6);
        mStart = (TextView) findViewById(R.id.tv_sart);
        mSq = (TextView) findViewById(R.id.tv_sq);
    }

    private void initTouch() {
        mBut1.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mBut2.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mBut3.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mBut4.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mBut5.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mBut6.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mBut1.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh5Activity.this, ProRes.funUrl);
                } else {
                    ProRes.ClosePlayer();
                }
            }
        });
        mChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh5Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mChose.setText(string);
                    }
                });
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditext.getText())) {
                    AlertUtils.ToastView(Moh5Activity.this, "请输入操作码");
                } else {
                    Seelp();
                }
            }
        });
mSq.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(Moh5Activity.this, Main2Activity.class);
        startActivity(myIntent);
    }
});
    }

    private void Seelp() {
        NetWork.getData(this, mEditext.getText().toString(), new Call() {
            @Override
            public void OnOk() {

            }

            @Override
            public void OnNo() {

            }
        });

    }
}