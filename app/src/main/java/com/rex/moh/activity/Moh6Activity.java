package com.rex.moh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
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

public class Moh6Activity extends AppCompatActivity implements ToggleButton.OnToggleChanged {


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
    private int IsFlag;
    private TextView mSQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moh6);
        initView();
        initOntouch();
        mIntent=getIntent();
        mMohBean= (Mohbean) mIntent.getSerializableExtra("user");
        mMohTetle.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
         mXzlx.setText(mMohBean.getAllData().get(mMohBean.Pos).getName());
    }

    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            ProRes.openPlayer(Moh6Activity.this,ProRes.fun[(int) (Math.random() * 27)]);
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
                    AlertUtils.ToastView(Moh6Activity.this,"请输入操作码");
                }else{
                    Seelp();
                }

            }
        });
        mSQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Moh6Activity.this,Main2Activity .class);
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
                if (on) {
                    startMoh();
                }else{
                    stopMoh();
                }
            }
        });
        mB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
               mList.add("同花顺");
                mList.add("炸弹");
                mList.add("顺子");
                mList.add("三同张");
                mList.add("飞机带翅膀");
                ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB1.setText(string);
                    }
                });
            }
        });
  mB2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          List<String> mList=new ArrayList<String>();
          mList.add("对对碰");
          mList.add("天湖");
          mList.add("自摸");
          mList.add("乌胡");
          mList.add("红胡");
          mList.add("大");
          mList.add("小");
          mList.add("海底胡");
          mList.add("真点胡");
          mList.add("假点胡");
          ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
              @Override
              public void Ok(String string) {
                  mB2.setText(string);
              }
          });
      }
  });
mB3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        List<String> mList=new ArrayList<String>();
        mList.add("双A");
        mList.add("花A");
        mList.add("5小A");
        mList.add("21点");
        mList.add("20点");
        mList.add("19点");
        ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
            @Override
            public void Ok(String string) {
                mB3.setText(string);
            }
        });
    }
});
        mB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                 mList.add("豹子");
                mList.add("顺子");
                mList.add("对子");
                ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB4.setText(string);
                    }
                });
            }
        });
        mB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                 mList.addAll(mMohBean.getPercentage());
                ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB5.setText(string);
                    }
                });
            }
        });
        mB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getCardType());
                ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mB6.setText(string);
                    }
                });
            }
        });
        mXzlx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mList=new ArrayList<String>();
                mList.addAll(mMohBean.getAllData().get(mMohBean.Pos).getList());
                ProRes.showDialog(Moh6Activity.this,mList, new Callss() {
                    @Override
                    public void Ok(String string) {
                        mXzlx.setText(string);
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
        mBtn4=(ToggleButton) findViewById(R.id.bv_btn4);
        mXzlx=(TextView) findViewById(R.id.tv_xzlx);
        mEdtex=(EditText) findViewById(R.id.editText);
        mMohTetle=(TextView) findViewById(R.id.tv_title);
        mStart=(TextView) findViewById(R.id.tv_sart);
        mSQ=(TextView) findViewById(R.id.tv_sq);
        mB1=(TextView) findViewById(R.id.tv_b1);
        mB2=(TextView) findViewById(R.id.tv_b2);
        mB3=(TextView) findViewById(R.id.tv_b3);
        mB4=(TextView) findViewById(R.id.tv_b4);
        mB5=(TextView) findViewById(R.id.tv_pdk_hh);
        mB6=(TextView) findViewById(R.id.tv_b6);
        mB1.setText("同花顺");
        mB2.setText("对对碰");
        mB3.setText("双A");
        mB4.setText("豹子");
        mB5.setText("好牌机率10%");
        mB6.setText("随机好牌");




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
                    ProRes.openPlayer(Moh6Activity.this,ProRes.funUrl);
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
