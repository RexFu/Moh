package com.rex.moh.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class MohActivity extends AppCompatActivity implements ToggleButton.OnToggleChanged {


    private ToggleButton mBtn1;
    private ToggleButton mBtn2;
    private ToggleButton mBtn3;
    private ToggleButton mBtn4;
    private ToggleButton mBtn5;
    private ToggleButton mBtn6;
    private ToggleButton mBtn7;
    private ToggleButton mBtn8;
    private ToggleButton mBtn9;
    private ToggleButton mBtn10;
    private TextView mXzlx;
    private TextView mXzlXhh;
    private TextView mPdk;
    private TextView mPhz;
    private Intent mIntent;
    private Mohbean mMohBean;
    private TextView mQspx;
    private TextView mSQ;
    private TextView mMohTetle;
    private TextView mStart;
    private EditText mEdtex;
    private int IsFlag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh);
        initView();
        initOntouch();
        mIntent=getIntent();
        mMohBean= (Mohbean) mIntent.getSerializableExtra("user");
        mXzlx.setText(mMohBean.getAllData().get(mMohBean.Pos).getList().get(0));
        mXzlXhh.setText(mMohBean.getPercentage().get(0));
        mPdk.setText(mMohBean.getRunFast().get(0));
        mPhz.setText(mMohBean.getRunBeard().get(0));
        mQspx.setText(mMohBean.getCardType().get(0));
        mMohTetle.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
    }
    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            ProRes.openPlayer(MohActivity.this,ProRes.fun[(int) (Math.random() * 27)]);
            handler.postDelayed(this, 8000);
        }
    };
    private void initOntouch() {
        mBtn1.setOnToggleChanged(this);
        mBtn2.setOnToggleChanged(this);
        mBtn3.setOnToggleChanged(this);
        mBtn5.setOnToggleChanged(this);
        mBtn6.setOnToggleChanged(this);
        mBtn7.setOnToggleChanged(this);
        mBtn8.setOnToggleChanged(this);
        mBtn9.setOnToggleChanged(this);
        mBtn10.setOnToggleChanged(this);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEdtex.getText())) {
                    AlertUtils.ToastView(MohActivity.this,"请输入操作码");
                }else{
                    Seelp();
                }

            }
        });
        mSQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MohActivity.this, Main2Activity.class);
                startActivity(myIntent);
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
                ProRes.openPlayer(MohActivity.this,ProRes.funUrl);
            }
        });
        mXzlx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(MohActivity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mXzlx.setText(string);
                    }
                });
            }
        });
        mQspx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getCardType());
                ProRes.showDialog(MohActivity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mQspx.setText(string);
                    }
                });
            }
        });
        mXzlXhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getPercentage());
                ProRes.showDialog(MohActivity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mXzlXhh.setText(string);
                    }
                });

            }
        });
        mPdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getRunFast());
                ProRes.showDialog(MohActivity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mPdk.setText(string);
                    }
                });

            }
        });
        mPhz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getRunBeard());
                ProRes.showDialog(MohActivity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mPhz.setText(string);
                    }
                });


            }
        });
    }

    private void Seelp() {
        NetWork.getData(this, mEdtex.getText().toString(), new Call() {
            @Override
            public void OnOk() {
                IsFlag=1;
            }

            @Override
            public void OnNo() {
                IsFlag=0;
            }
        });


    }

    private void initView() {
        mBtn1=(ToggleButton) findViewById(R.id.bv_btn1);
        mBtn2=(ToggleButton) findViewById(R.id.bv_btn2);
        mBtn3=(ToggleButton) findViewById(R.id.bv_btn3);
        mBtn4=(ToggleButton) findViewById(R.id.bv_btn4);
        mSQ=(TextView) findViewById(R.id.tv_sq);
        mBtn5=(ToggleButton) findViewById(R.id.bv_btn6);
        mBtn6=(ToggleButton) findViewById(R.id.bv_btn7);
        mBtn7=(ToggleButton) findViewById(R.id.bv_btn8);
        mBtn8=(ToggleButton) findViewById(R.id.bv_btn9);
        mBtn9=(ToggleButton) findViewById(R.id.bv_btn10);
        mBtn10=(ToggleButton) findViewById(R.id.bv_btn11);
        mXzlx=(TextView) findViewById(R.id.tv_xzlx);
        mXzlXhh=(TextView) findViewById(R.id.tv_xzlex);
        mPdk=(TextView) findViewById(R.id.tv_pdk_hh);
        mEdtex=(EditText) findViewById(R.id.editText);
        mPhz=(TextView) findViewById(R.id.tv_phz_hh);
        mQspx=(TextView) findViewById(R.id.tv_qspx);
        mMohTetle=(TextView) findViewById(R.id.tv_title);
        mStart=(TextView) findViewById(R.id.tv_sart);


    }
    private void stopMoh() {
        handler.removeCallbacks(runnable);
    }

    private void startMoh() {
        if(IsFlag==1&&!TextUtils.isEmpty(mEdtex.getText())){
            ProRes.openPlayer(this,ProRes.funUrl);
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 8000);//每两秒执行一次runnable.
        }else{
            mBtn4.setToggleOff();
            AlertUtils.showCleanCache(this,"请输入授权码,点击“启动游戏”");
        }

    }
    @Override
    public void onToggle(boolean on) {
        if (on) {
                    ProRes.openPlayer(MohActivity.this,ProRes.funUrl);
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
