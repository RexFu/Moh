package com.rex.moh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
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

public class Moh3Activity extends AppCompatActivity implements ToggleButton.OnToggleChanged {


    private ToggleButton mBtn1;
    private ToggleButton mBtn2;
    private ToggleButton mBtn4;
    private TextView mXzlx;

    private Intent mIntent;
    private Mohbean mMohBean;
    private TextView mMohTetle;
    private TextView mStart;
    private EditText mEdtex;
    private TextView mB1;
    private TextView mB6;
    private TextView mB5;
    private TextView mB4;
    private TextView mB3;
    private TextView mB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh3);
        initView();
        initOntouch();
        mIntent=getIntent();
        mMohBean= (Mohbean) mIntent.getSerializableExtra("user");
        mXzlx.setText(mMohBean.getAllData().get(mMohBean.Pos).getList().get(0));
        mMohTetle.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
    }
    Handler handler1=new Handler();
    Runnable runnable1=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            //要做的事情.
            AlertUtils.isDismiss();
            AlertUtils.ToastView(Moh3Activity.this,"操作失败：操作码有误...");
        }
    };
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            ProRes.openPlayer(Moh3Activity.this,ProRes.fun[(int) (Math.random() * 27)]);
            handler.postDelayed(this, 8000);
        }
    };
    private void initOntouch() {
        mBtn1.setOnToggleChanged(this);
        mBtn2.setOnToggleChanged(this);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEdtex.getText())) {
                    AlertUtils.ToastView(Moh3Activity.this,"请输入操作码");
                }else{
                    Seelp();
                }

            }
        });
        mBtn4.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    startMoh();
                }else{
                    stopMoh();
                }
            }
        });
        mBtn2.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                if (on) {
                    startMoh();
                }else{
                    stopMoh();
                }
            }
        });
        mXzlx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mXzlx.setText(string);
                    }
                });
            }
        });
        mB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB6.setText(string);
                    }
                });
            }
        });
  mB2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          List<String> mList=new ArrayList<String>();
          mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
          ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
              @Override
              public void Ok(String string) {
                  mB6.setText(string);
              }
          });
      }
  });
mB3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        List<String> mList=new ArrayList<String>();
        mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
        ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
            @Override
            public void Ok(String string) {
                mB6.setText(string);
            }
        });
    }
});
        mB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB6.setText(string);
                    }
                });
            }
        });
        mB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB6.setText(string);
                    }
                });
            }
        });
        mB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh3Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB6.setText(string);
                    }
                });
            }
        });
    }

    private void Seelp() {
        AlertUtils.isShowLoad(Moh3Activity.this);
        handler1.postDelayed(runnable1, 2000);


    }

    private void initView() {
        mBtn1=(ToggleButton) findViewById(R.id.bv_btn1);
        mBtn2=(ToggleButton) findViewById(R.id.bv_btn2);
        mBtn4=(ToggleButton) findViewById(R.id.bv_btn4);
        mXzlx=(TextView) findViewById(R.id.tv_xzlx);
        mEdtex=(EditText) findViewById(R.id.editText);
        mMohTetle=(TextView) findViewById(R.id.tv_title);
        mStart=(TextView) findViewById(R.id.tv_sart);
        mB1=(TextView) findViewById(R.id.tv_b1);
        mB2=(TextView) findViewById(R.id.tv_b2);
        mB3=(TextView) findViewById(R.id.tv_b3);
        mB4=(TextView) findViewById(R.id.tv_b4);
        mB5=(TextView) findViewById(R.id.tv_b5);
        mB6=(TextView) findViewById(R.id.tv_b6);



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
                    ProRes.openPlayer(Moh3Activity.this,ProRes.funUrl);
                }else{
                    ProRes.ClosePlayer();
                }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ProRes.ClosePlayer();
        stopMoh();
    }
}
