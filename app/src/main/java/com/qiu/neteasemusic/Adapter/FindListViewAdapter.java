package com.qiu.neteasemusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qiu.neteasemusic.Bean.FindListViewBean;
import com.qiu.neteasemusic.Interface.FindListViewListener;
import com.qiu.neteasemusic.R;
import com.youth.banner.Banner;

import java.util.List;

/**
 * Created by qiu on 2017/4/13.
 */

public class FindListViewAdapter extends BaseAdapter {
    private Context context;
    private List<FindListViewBean> listdata;
    private FindListViewListener listener;
    public FindListViewAdapter(Context context, List<FindListViewBean> list,
                               FindListViewListener listener){
        this.context=context;
        this.listdata=list;
        this.listener=listener;
    }
    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            FindListViewBean findListViewBean = listdata.get(position);
            if(findListViewBean!=null){
                switch (findListViewBean.getItemType()){
                    case FindListViewBean.ITEM_TYPE_BANNER://轮播图
                        convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_banner, null);
                        holder.banner = (Banner) convertView.findViewById(R.id.banner_find);
                        holder.tv_title= (TextView) convertView.findViewById(R.id.tv_detail);
                        break;
                }

            }
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        initData(convertView,holder,position);
        return convertView;
    }

    private void initData(View convertView, ViewHolder holder, int position) {
        FindListViewBean findListViewBean = listdata.get(position);
        if(findListViewBean!=null){
            switch (findListViewBean.getItemType()){
                case FindListViewBean.ITEM_TYPE_BANNER://轮播图
                    listener.initViewsSetting(convertView,holder,position);
                    break;
            }
        }
    }

    public final class ViewHolder {
         public Banner banner;
         public TextView tv_title;

    }
    public void refresh(List<FindListViewBean> list){
        listdata=list;
        notifyDataSetChanged();
    }
}
