package com.rex.moh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class Moh12Activity extends AppCompatActivity implements ToggleButton.OnToggleChanged{

    private ToggleButton mBut1;
    private ToggleButton mBut3;
    private ToggleButton mBut4;
    private ToggleButton mBut5;
    private ToggleButton mBut6;
    private ToggleButton mBut7;
    private ToggleButton mBut8;
    private ToggleButton mBut9;
    private ToggleButton mBut10;
    private ToggleButton mBut11;
    private ToggleButton mBut12;
    private ToggleButton mBut13;
    private ToggleButton mBut14;
    private EditText mEditext;
    private TextView mXZ;
    private Intent mIntent;
    private Mohbean mMohBean;
    private TextView mStart;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh12);
        initView();
        initTouch();
    }
    private void initTouch() {
        mBut1.setOnToggleChanged(this);
        mBut3.setOnToggleChanged(this);
        mBut4.setOnToggleChanged(this);
        mBut5.setOnToggleChanged(this);
        mBut6.setOnToggleChanged(this);
        mBut7.setOnToggleChanged(this);
        mBut8.setOnToggleChanged(this);
        mBut9.setOnToggleChanged(this);
        mBut10.setOnToggleChanged(this);
        mBut11.setOnToggleChanged(this);
        mBut12.setOnToggleChanged(this);
        mBut13.setOnToggleChanged(this);
        mBut14.setOnToggleChanged(this);
        mXZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh12Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mXZ.setText(string);
                    }
                });
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Moh12Activity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });


    }
    public String mString;
    private void initView() {
        mBut1=(ToggleButton) findViewById(R.id.bv_btn1);
        mBut3=(ToggleButton) findViewById(R.id.bv_btn3);
        mBut4=(ToggleButton) findViewById(R.id.bv_btn4);
        mBut5=(ToggleButton) findViewById(R.id.bv_btn5);
        mBut6=(ToggleButton) findViewById(R.id.bv_btn6);
        mBut7=(ToggleButton) findViewById(R.id.bv_btn7);
        mBut8=(ToggleButton) findViewById(R.id.bv_btn8);
        mBut9=(ToggleButton) findViewById(R.id.bv_btn9);
        mBut10=(ToggleButton) findViewById(R.id.bv_btn10);
        mBut11=(ToggleButton) findViewById(R.id.bv_btn11);
        mBut12=(ToggleButton) findViewById(R.id.bv_btn12);
        mBut13=(ToggleButton) findViewById(R.id.bv_btn13);
        mBut14=(ToggleButton) findViewById(R.id.bv_btn14);
        mEditext=(EditText) findViewById(R.id.editText);
        mTextView=(TextView) findViewById(R.id.tv_sq);
        mXZ=(TextView) findViewById(R.id.tv_xzlx);

        mStart=(TextView) findViewById(R.id.tv_sart);
        mIntent = getIntent();
        mMohBean = (Mohbean) mIntent.getSerializableExtra("user");
        mXZ.setText(mMohBean.getAllData().get(mMohBean.Pos).getList().get(0));
        mStart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                mString=mEditext.getText().toString();
                if (TextUtils.isEmpty(mString)) {
                    AlertUtils.ToastView(Moh12Activity.this, "请输入操作码");
                } else {
                    Seelp();
                }

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
