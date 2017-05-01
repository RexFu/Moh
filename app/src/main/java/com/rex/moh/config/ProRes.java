package com.rex.moh.config;

import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rex.moh.R;
import com.rex.moh.activity.Moh2Activity;
import com.rex.moh.bean.Mohbean;
import com.rex.moh.listener.Callss;
import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex on 2017/4/23.
 */

public class ProRes {
    private static Mohbean mMohBean;
    private static MediaPlayer player;
    public static String funUrl="video/funstart.MP3";
    public static String funopen="video/openstart.MP3";
    public static final int[] BitNam = {
            R.mipmap.a1,R.mipmap.a2,R.mipmap.a27, R.mipmap.a3, R.mipmap.a4,R.mipmap.a5, R.mipmap.a6,
            R.mipmap.a7,R.mipmap.a8, R.mipmap.a9, R.mipmap.a10,R.mipmap.a11, R.mipmap.a12,
            R.mipmap.a13,R.mipmap.a14, R.mipmap.a15, R.mipmap.a16,R.mipmap.a17,R.mipmap.a20,
             R.mipmap.a21, R.mipmap.a22,R.mipmap.a26,  R.mipmap.a28,R.mipmap.a29, R.mipmap.a30,
            R.mipmap.a34, R.mipmap.a32, R.mipmap.a33, R.mipmap.a35, R.mipmap.a36,
            R.mipmap.a23,
            R.mipmap.a42,
           R.mipmap.a38, R.mipmap.a39, R.mipmap.a40,R.mipmap.a41, R.mipmap.a43,R.mipmap.a31,R.mipmap.a44,R.mipmap.a25
                                };
    public static final String[] fun={"video/a1.MP3","video/a2.MP3","video/a3.MP3","video/a4.MP3","video/a4.MP3",
            "video/a5.MP3","video/a6.MP3","video/a7.MP3","video/a8.MP3","video/a9.MP3","video/b1.MP3","video/b2.MP3",
            "video/b3.MP3","video/b4.MP3","video/b5.MP3","video/b6.MP3","video/b7.MP3","video/b8.MP3","video/b9.MP3",
            "video/c1.MP3","video/c2.MP3","video/c3.MP3","video/c4.MP3","video/c5.MP3","video/c6.MP3","video/c7.MP3",
            "video/c8.MP3",
            "video/c9.MP3",
            "video/d1.MP3",

    };
    private static int Pos;

    public static Mohbean NameStr(Context mContext){

        try {
            InputStreamReader isr = new InputStreamReader(mContext.getAssets().open("file/moh.txt"),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while((line = br.readLine()) != null){
                builder.append(line);
            }
            br.close();
            isr.close();
          //这里作
            Gson mGson = new Gson();
            mMohBean=mGson.fromJson(builder.toString(), Mohbean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mMohBean;
    }
    public static void openPlayer(Context mContext,String videoUrl){
        try {
            if(player!=null&&player.isPlaying()){
                player.stop();
            }
            AssetManager assetManager = mContext.getAssets();
            AssetFileDescriptor afd = assetManager.openFd(videoUrl);
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(), afd.getLength());
            player.prepare();
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void ClosePlayer(){
        if (player!=null) {
            player.stop();
        }
    }

    public static void showDialog(final Context mContext, final List<String> mList, final Callss mlisenr) {
        final Dialog dialog = new Dialog(mContext, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(mContext).inflate(R.layout.dialog_view,null);
        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        //将自定义布局加载到dialog上
        dialog.setContentView(dialogView);
        window.setContentView(R.layout.dialog_view);
         LoopView loopView = (LoopView) window.findViewById(R.id.loopView);
        loopView.setNotLoop();
        TextView mBtnCancle = (TextView) window.findViewById(R.id.tv_cancle);
        TextView mBtnOk = (TextView) window.findViewById(R.id.tv_ok);
            loopView.setInitPosition(Pos);
        mBtnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                dialog.cancel(); }
        });
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlisenr.Ok(mList.get(Pos));
                dialog.cancel();
            }
        });
        // 滚动监听

        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {

            Pos =index;
            }
        });
        // 设置原始数据
        loopView.setItems(mList);
        dialog.show();
    }

    /**
     * 获得设备的唯一的id
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm=((TelephonyManager) context.getSystemService( Context.TELEPHONY_SERVICE ));
        String DEVICE_ID = tm.getDeviceId();
        return DEVICE_ID;

    }


}
