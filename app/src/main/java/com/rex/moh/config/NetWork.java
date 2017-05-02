package com.rex.moh.config;
import android.content.Context;
import android.util.Log;

import com.rex.td_http.config.DataState;
import com.rex.td_http.http.HttpUtils;
import com.rex.td_http.listener.CallBack;

import java.util.HashMap;

/**
 * Created by Rex on 2017/4/29.
 */

public class NetWork {
    private static boolean IsBoolean;

    public static  void  getData(final Context mContext, String mStr, final Call listener){
        AlertUtils.isShowLoad(mContext);
        HashMap<String, String> mParm = new HashMap<String, String>();
        mParm.put("项目名称","测试项目");
        mParm.put("flag","注册码登录");
        mParm.put("机器码",ProRes.getDeviceId(mContext));
        mParm.put("注册码",mStr);
        HttpUtils.get().params(mParm).setUrl("http://get.baibaoyun.com/api/bcfc5d0db987700a416fa63725f30f5a").taskId(0xf001).build(DataState.NO_CACHE).execute(new CallBack() {
            @Override
            public void onSuccess(Object obj, long taskId) {
                if (obj.toString().indexOf("登录成功")!=-1) {
                    AlertUtils.ToastView(mContext,"登录成功");
                    ProRes.openPlayer(mContext,"video/a1.MP3");
                    AlertUtils.isDismiss();
                    listener.OnOk();
                }else{
                    AlertUtils.ToastView(mContext,obj.toString());
                    listener.OnNo();
                    AlertUtils.isDismiss();
                }

            }

            @Override
            public void onFailure(Object obj, long taskId) {
                AlertUtils.ToastView(mContext,obj.toString());
                listener.OnNo();
                AlertUtils.isDismiss();

            }
        });
    }
}
