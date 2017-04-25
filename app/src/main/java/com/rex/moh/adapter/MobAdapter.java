package com.rex.moh.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rex.moh.config.ProRes;
import com.rex.moh.R;


/**
 * Created by wangwenfu on 2016/10/18.
 * 栏目的Adapter
 */
public class MobAdapter extends BaseAdapter {
    private Activity mActivity;
    private Context mContext;

    public MobAdapter(Context mContext) {
        mActivity = (Activity) mContext;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return ProRes.BitNam.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false);
            holder.mIcon= (ImageView) convertView.findViewById(R.id.iv_icon);
            holder.mName= (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.mIcon.setImageResource(ProRes.BitNam[position]);
       holder.mName.setText(ProRes.NameStr(mContext).getAllData().get(position).getName());
        return convertView;
    }

   class ViewHolder {
        ImageView mIcon;
        TextView mName;


    }
}
