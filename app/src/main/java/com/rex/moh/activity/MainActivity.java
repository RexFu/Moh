package com.rex.moh.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.rex.moh.R;
import com.rex.moh.adapter.MobAdapter;
import com.rex.moh.bean.Mohbean;
import com.rex.moh.config.ProRes;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mListView;
    private TextView mSQ;
    private MobAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProRes.openPlayer(this,ProRes.funopen);
        initView();
        initData();
        setTouch();
    }

    /**
     * 点击事件
     */
    private void setTouch() {
        mListView.setOnItemClickListener(this);

    }

    /**
     * 设置数据
     */
    private void initData() {
      mAdapter=  new MobAdapter(this);
        mListView.setAdapter(mAdapter);

    }

    /**
     * 找到id
     */

    private void initView() {
        mListView=(GridView) findViewById(R.id.lv_view);
        mSQ=(TextView) findViewById(R.id.tv_sq);
        mSQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==1||position==7||position==4||position==5||position==8||position==12||position==22||position==25){
            Intent myIntent = new Intent(MainActivity.this,MohActivity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean=ProRes.NameStr(MainActivity.this);
            mohbean.Pos=position;
            bundle.putSerializable("user",mohbean );
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }else {
            Intent myIntent = new Intent(MainActivity.this, Moh2Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean=ProRes.NameStr(MainActivity.this);
            mohbean.Pos=position;
            bundle.putSerializable("user",mohbean );
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ProRes.ClosePlayer();
    }
}
