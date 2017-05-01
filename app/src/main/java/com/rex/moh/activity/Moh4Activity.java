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

public class Moh4Activity extends AppCompatActivity {


    private ToggleButton mB1;
    private ToggleButton mB2;
    private ToggleButton mB3;
    private ToggleButton mB4;
    private ToggleButton mB5;
    private ToggleButton mB6;
    private TextView mStart;
    private EditText mSqma;
    private TextView mTextView;
    private Intent mIntent;
    private Mohbean mMohBean;
    private TextView mMz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh4);
        initView();
        initOntouch();
        mIntent=getIntent();
        mMohBean= (Mohbean) mIntent.getSerializableExtra("user");
        mTextView.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
    }

    private void initOntouch() {
        mB1.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh4Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
            }
        });
        mB2.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh4Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
            }
        });
        mB3.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh4Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
            }
        });
        mB4.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh4Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
            }
        });
        mB5.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh4Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
            }
        });
        mB6.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    ProRes.openPlayer(Moh4Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mSqma.getText())) {
                    AlertUtils.ToastView(Moh4Activity.this,"请输入操作码");
                }else{
                    Seelp();
                }
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh4Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mTextView.setText(string);
                    }
                });
            }
        });
        mMz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.add("命中率10%");
                mList.add("命中率20%");
                mList.add("命中率30%");
                mList.add("命中率40%");
                mList.add("命中率50%");
                mList.add("命中率60%");
                mList.add("命中率70%");
                mList.add("命中率80%");
                mList.add("命中率90%");
                mList.add("命中率100%");
                ProRes.showDialog(Moh4Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mMz.setText(string);
                    }
                });

            }
        });
    }
    private void Seelp() {
        NetWork.getData(this, mSqma.getText().toString(), new Call() {
            @Override
            public void OnOk() {

            }
            @Override
            public void OnNo() {

            }
        });


    }
    private void initView() {
        mB1=(ToggleButton) findViewById(R.id.bv_btn1);
        mB2=(ToggleButton) findViewById(R.id.bv_btn1);
        mB3=(ToggleButton) findViewById(R.id.bv_btn1);
        mB4=(ToggleButton) findViewById(R.id.bv_btn1);
        mB5=(ToggleButton) findViewById(R.id.bv_btn1);
        mB6=(ToggleButton) findViewById(R.id.bv_btn1);
        mStart=(TextView) findViewById(R.id.tv_sart);
        mSqma=(EditText) findViewById(R.id.editText);
        mTextView=(TextView) findViewById(R.id.tv_xzlx);
        mMz=(TextView) findViewById(R.id.tv_b7);
        findViewById(R.id.tv_sq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Moh4Activity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });

    }
}
