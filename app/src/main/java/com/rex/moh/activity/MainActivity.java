package com.rex.moh.activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.rex.moh.R;
import com.rex.moh.adapter.MobAdapter;
import com.rex.moh.bean.Mohbean;
import com.rex.moh.config.ProRes;
import com.rex.moh.config.TdSpUtils;
import com.rex.td_http.http.MvcPointer;
import com.rex.td_http.http.VolleyProxy;
import com.rex.td_http.listener.HttpProxy;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mListView;
    private TextView mSQ;
    private MobAdapter mAdapter;
    private Long mOldTime;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private long mNewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProRes.openPlayer(this, ProRes.funopen);
        MvcPointer.init(this.getApplicationContext(), true, VolleyProxy.getInstance(this));
        initView();
        initData();
        setTouch();
        mOldTime = TdSpUtils.getInstance(this).getValue("data",Long.valueOf(0));
Log.e("flag--","MainActivity--onCreate--48--"+mOldTime);
        if(mOldTime==0){
            TdSpUtils.getInstance(this).setValue("data", System.currentTimeMillis());
        }else{
            mNewTime= System.currentTimeMillis();
            Log.e("flag--","MainActivity--onCreate--48--"+(mOldTime-mNewTime));

            if ((mNewTime-mOldTime)>300000000) {
                finish();
                return;
            }
        }
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
        mAdapter = new MobAdapter(this);
        mListView.setAdapter(mAdapter);

    }

    /**
     * 找到id
     */

    private void initView() {
        mListView = (GridView) findViewById(R.id.lv_view);
        mSQ = (TextView) findViewById(R.id.tv_sq);
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
        Log.e("flag--", "MainActivity--onItemClick--71--" + position);
        if (position == 1 || position == 7 || position == 4 || position == 5 || position == 8 || position == 12 || position == 22 || position == 25) {
            Intent myIntent = new Intent(MainActivity.this, MohActivity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 39) {
            Intent myIntent = new Intent(MainActivity.this, Moh3Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 30) {
            Intent myIntent = new Intent(MainActivity.this, Moh4Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 36) {
            Intent myIntent = new Intent(MainActivity.this, Moh6Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 34) {
            Intent myIntent = new Intent(MainActivity.this, Moh5Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);

        } else if (position == 33) {
            Intent myIntent = new Intent(MainActivity.this, Moh7Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 35) {
            Intent myIntent = new Intent(MainActivity.this, Moh9Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 31) {
            Intent myIntent = new Intent(MainActivity.this, Moh10Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 32) {
            Intent myIntent = new Intent(MainActivity.this, Moh12Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        } else if (position == 29) {
            Intent myIntent = new Intent(MainActivity.this, Moh11Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);

        } else {
            Intent myIntent = new Intent(MainActivity.this, Moh2Activity.class);
            Bundle bundle = new Bundle();
            Mohbean mohbean = ProRes.NameStr(MainActivity.this);
            mohbean.Pos = position;
            bundle.putSerializable("user", mohbean);
            myIntent.putExtras(bundle);
            startActivity(myIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ProRes.ClosePlayer();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
