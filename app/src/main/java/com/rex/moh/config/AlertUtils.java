package com.rex.moh.config;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.rex.moh.R;

/**
 * Created by wangwenfu on 2016/10/27.
 */
public class AlertUtils {
    private static AlertDialog NonNet;
    private static AlertDialog CleanCache;
    private static AlertDialog mDeletTag;
    private static AlertDialog mLoading;
    private static Toast toast;
    private static AlertDialog isLoginDialog;


    /**
     * 加载的loading
     */
    public static void isShowLoad(final Context context) {
        if (mLoading != null &&mLoading.isShowing()&&context!=null) {
            return;
        }
        if (context instanceof Activity) {
            Activity temp = (Activity) context;
            if (temp.isFinishing()) {
                return;
            }
        }else{
            return;
        }
        mLoading = new AlertDialog.Builder(context).create();
        mLoading.show();
        Window window = mLoading.getWindow();
        mLoading.setCanceledOnTouchOutside(false);
        WindowManager m = window.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.4); // 宽度设置为屏幕
        p.height = (int) (d.getWidth() * 0.4);
        window.setAttributes(p);
        window.setContentView(R.layout.dialog_loading);
    }

    public static void isDismiss() {
        if (mLoading != null && mLoading.isShowing()) {
            mLoading.dismiss();

        }

    }

    /**
     * @param context
     * @param text    自定义toas
     */

    public static void ToastView(final Context context, final String text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                toast = new Toast(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.toast_view, null);
                TextView t = (TextView) view.findViewById(R.id.toast_text);
                t.setText(text);
                if (toast != null) {
                    toast.cancel();
                }
                toast = new Toast(context);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

    }
    /**
     * @param context   说明
     * @param aCacheSize
     */
    public static void showCleanCache(final Context context, String aCacheSize) {
        if (CleanCache != null && CleanCache.isShowing()) {
            CleanCache.dismiss();
        }
        CleanCache = new AlertDialog.Builder(context).create();
        CleanCache.show();
        Window window = CleanCache.getWindow();
        CleanCache.setCanceledOnTouchOutside(false);
        WindowManager m = window.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕
        window.getDecorView().setBackgroundColor(0X00000000);
        window.setAttributes(p);
        window.setContentView(R.layout.dialog_clean_cache);
        TextView mCleanCacheOk = (TextView) window.findViewById(R.id.btn_cancel_ok);
        mCleanCacheOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CleanCache.dismiss();
            }
        });
    }

}
