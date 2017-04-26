package com.rex.moh.activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rex.moh.R;
import com.rex.moh.bean.Mohbean;
import com.rex.moh.config.AlertUtils;
import com.rex.moh.config.ProRes;
import com.rex.moh.listener.Callss;
import com.rex.moh.view.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Moh2Activity extends AppCompatActivity implements ToggleButton.OnToggleChanged,View.OnClickListener{

    private ToggleButton mButton1;
    private ToggleButton mButton7;
    private ToggleButton mButton3;
    private ToggleButton mButton2;
    private ToggleButton mButton5;
    private ToggleButton mButton6;
    private ToggleButton mButton4;
    private TextView mChose;
    private android.app.AlertDialog mLoading;
    private Intent mIntent;
    private Mohbean mMohBean;
    private TextView mTitle;
    private TextView mChoseLexin;
    private TextView mChosePaiXin;
    private TextView mSQ;
    private TextView mStart;
    private EditText mEditext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh2);
        initView();
        initTouche();
        initData();
    }
    Handler handler1=new Handler();
    Runnable runnable1=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            //要做的事情.
            AlertUtils.isDismiss();
            AlertUtils.ToastView(Moh2Activity.this,"操作失败：操作码有误...");
        }
    };
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            ProRes.openPlayer(Moh2Activity.this,ProRes.fun[(int) (Math.random() * 27)]);
            handler.postDelayed(this, 8000);
        }
    };
    private void initData() {
        mTitle.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
        mChose.setText(mMohBean.getAllData().get(mMohBean.Pos).getList().get(0));
        mChoseLexin.setText(mMohBean.getPercentage().get(0));
        mChosePaiXin.setText(mMohBean.getCardType().get(0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ProRes.ClosePlayer();
        stopMoh();
    }

    private void initTouche() {
        mButton1.setOnToggleChanged(this);
        mButton3.setOnToggleChanged(this);
        mButton4.setOnToggleChanged(this);
        mButton5.setOnToggleChanged(this);
        mButton6.setOnToggleChanged(this);
        mButton7.setOnToggleChanged(this);
        mChose.setOnClickListener(this);
        mChoseLexin.setOnClickListener(this);
        mChosePaiXin.setOnClickListener(this);
        mIntent=getIntent();
        mMohBean= (Mohbean) mIntent.getSerializableExtra("user");
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditext.getText())) {
                    AlertUtils.ToastView(Moh2Activity.this,"请输入操作码");
                }else{
                    Seelp();
                }

            }
        });
    }

    private void Seelp() {
        AlertUtils.isShowLoad(Moh2Activity.this);
        handler1.postDelayed(runnable1, 2000);
    }

    /**
     * 寻找id
     */

    private void initView() {
        mButton1=(ToggleButton) findViewById(R.id.bv_btn1);
        mButton2=(ToggleButton) findViewById(R.id.bv_btn4);
        mButton3=(ToggleButton) findViewById(R.id.bv_btn2);
        mButton4=(ToggleButton) findViewById(R.id.bv_btn7);
        mButton5=(ToggleButton) findViewById(R.id.bv_btn6);
        mButton6=(ToggleButton) findViewById(R.id.bv_btn8);
        mButton7=(ToggleButton) findViewById(R.id.bv_btn12);
        mStart=(TextView) findViewById(R.id.tv_start);
        mSQ=(TextView) findViewById(R.id.textView);
        mEditext=(EditText) findViewById(R.id.editText);
        mChose=(TextView) findViewById(R.id.tv_chose);
        mTitle=(TextView) findViewById(R.id.tv_title);
        mChoseLexin=(TextView) findViewById(R.id.tv_xzlx);
        mChosePaiXin=(TextView) findViewById(R.id.tv_qspx);
        mButton2.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    startMoh();
                }else{
                    stopMoh();
                }
            }
        });
        mButton4.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    startMoh();
                }else{
                    stopMoh();
                }
            }
        });
        mSQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Moh2Activity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });

    }

    private void stopMoh() {
        handler.removeCallbacks(runnable);
    }

    private void startMoh() {
        ProRes.openPlayer(this,ProRes.funUrl);
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 8000);//每两秒执行一次runnable.
    }

    @Override
    public void onToggle(boolean on) {
        if (on) {
            ProRes.openPlayer(this,ProRes.funUrl);
        }else{
            ProRes.ClosePlayer();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_chose:
                Chose();
             break;
            case R.id.tv_xzlx:
                Chose1();
                break;
            case R.id.tv_qspx:
                Chose2();
             break;
        }

    }

    private void Chose2() {
        List<String> mList=new ArrayList<String>();
        mList.addAll(mMohBean.getCardType());
        ProRes.showDialog(Moh2Activity.this,mList, new Callss() {
            @Override
            public void Ok(String string) {
                mChosePaiXin.setText(string);
            }
        });
    }

    private void Chose1() {
        List<String> mList=new ArrayList<String>();
        mList.addAll(mMohBean.getPercentage());
        ProRes.showDialog(Moh2Activity.this,mList, new Callss() {
            @Override
            public void Ok(String string) {
                mChoseLexin.setText(string);
            }
        });
    }

    private void Chose() {
        List<String> mList=new ArrayList<String>();
        mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
        ProRes.showDialog(Moh2Activity.this,mList, new Callss() {
            @Override
            public void Ok(String string) {
                mChose.setText(string);
            }
        });
    }


}
