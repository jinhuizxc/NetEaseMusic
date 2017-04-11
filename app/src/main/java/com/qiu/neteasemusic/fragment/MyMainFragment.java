package com.qiu.neteasemusic.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.framework.greendroid.pulltorefresh.PullToRefreshBase;
import com.framework.greendroid.pulltorefresh.PullToRefreshListView;
import com.qiu.neteasemusic.Adapter.MyMainFragmentAdapter;
import com.qiu.neteasemusic.Base.AbstractBaseFragment;
import com.qiu.neteasemusic.Bean.MyMainFragmentBean;
import com.qiu.neteasemusic.R;
import com.qiu.neteasemusic.Utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiu on 2017/4/11.
 * 我的
 */

public class MyMainFragment  extends AbstractBaseFragment {
    private PullToRefreshListView listView=null;
    private MyMainFragmentAdapter mAdapter=null;
    private List<MyMainFragmentBean> listdata=null;
    private MyMainFragmentBean mBean=null;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_my_main;
    }

    @Override
    protected void initView(View v) {
        listView = (PullToRefreshListView) v.findViewById(R.id.fragment_my_pullListView);
        listdata=new ArrayList<>();
        mAdapter=new MyMainFragmentAdapter(getContext(),listdata);
        listView.setAdapter(mAdapter);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                ToastUtil.showToast(getContext(),"下拉");
                listView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                ToastUtil.showToast(getContext(),"上啦");
                listView.onRefreshComplete();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.showToast(getContext(),position+"");
            }
        });

    }
    @Override
    protected void initData() {
        mBean=new MyMainFragmentBean();
        mBean.setItemName("本地音乐");
        mBean.setItemNumName("(455)");
        listdata.add(mBean);

        mBean=new MyMainFragmentBean();
        mBean.setItemName("本地音乐");
        mBean.setItemNumName("(455)");
        listdata.add(mBean);

        mBean=new MyMainFragmentBean();
        mBean.setItemName("本地音乐");
        mBean.setItemNumName("(455)");
        listdata.add(mBean);

        mBean=new MyMainFragmentBean();
        mBean.setItemName("本地音乐");
        mBean.setItemNumName("(455)");
        listdata.add(mBean);
        mAdapter.refresh(listdata);

    }
}
