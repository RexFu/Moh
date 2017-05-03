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

public class Moh10Activity extends AppCompatActivity implements ToggleButton.OnToggleChanged{
    private ToggleButton mBut1;
    private ToggleButton mBut2;
    private ToggleButton mBut3;
    private ToggleButton mBut4;
    private ToggleButton mBut5;
    private ToggleButton mBut6;
    private ToggleButton mBut7;
    private EditText mEditext;
    private TextView mXZ;
    public String mString;
    private TextView mStart;
    private TextView mSQ;
    private Intent mIntent;
    private Mohbean mMohBean;
    private TextView mHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh10);
        initView();
        initTouch();
    }

    private void initView() {
        mBut1=(ToggleButton) findViewById(R.id.bv_btn1);
        mBut2=(ToggleButton) findViewById(R.id.bv_btn2);
        mBut3=(ToggleButton) findViewById(R.id.bv_btn3);
        mBut4=(ToggleButton) findViewById(R.id.bv_btn4);
        mBut5=(ToggleButton) findViewById(R.id.bv_btn5);
        mBut6=(ToggleButton) findViewById(R.id.bv_btn6);
        mBut7=(ToggleButton) findViewById(R.id.bv_btn7);
        mEditext=(EditText) findViewById(R.id.editText);
        mHp=(TextView) findViewById(R.id.tv_b9);
        mXZ=(TextView) findViewById(R.id.tv_xzlx);
        mSQ=(TextView) findViewById(R.id.tv_sq);
        mStart=(TextView) findViewById(R.id.tv_sart);
        mIntent = getIntent();
        mMohBean = (Mohbean) mIntent.getSerializableExtra("user");
        mXZ.setText(mMohBean.getAllData().get(mMohBean.Pos).getList().get(0));
        mXZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh10Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mXZ.setText(string);
                    }
                });
            }
        });
        mSQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Moh10Activity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View v) {
                mString=mEditext.getText().toString();
                if (TextUtils.isEmpty(mString)) {
                    AlertUtils.ToastView(Moh10Activity.this, "请输入操作码");
                } else {
                    Seelp();
                }

            }
        });
    }

    private void initTouch() {
        mBut1.setOnToggleChanged(this);
        mBut2.setOnToggleChanged(this);
        mBut3.setOnToggleChanged(this);
        mBut4.setOnToggleChanged(this);
        mBut5.setOnToggleChanged(this);
        mBut6.setOnToggleChanged(this);
        mBut7.setOnToggleChanged(this);
        mHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.add("好牌机率10%");
                mList.add("好牌机率20%");
                mList.add("好牌机率30%");
                mList.add("好牌机率40%");
                mList.add("好牌机率50%");
                mList.add("好牌机率60%");
                mList.add("好牌机率70%");
                mList.add("好牌机率80%");
                mList.add("好牌机率90%");
                mList.add("好牌机率100%");
                ProRes.showDialog(Moh10Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mHp.setText(string);
                    }
                });
            }
        });
    }
    private void Seelp() {
        NetWork.getData(this, mString, new Call() {
            @Override
            public void OnOk() {

            }

            @Override
            public void OnNo() {

            }
        });
    }
    @Override
    public void onToggle(boolean on) {
        if (on) {
            ProRes.openPlayer(this,ProRes.funUrl);
        }else{
            ProRes.ClosePlayer();
        }
    }
}
