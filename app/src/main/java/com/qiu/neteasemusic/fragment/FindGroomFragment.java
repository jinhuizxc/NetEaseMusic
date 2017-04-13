package com.qiu.neteasemusic.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.qiu.neteasemusic.Base.AbstractBaseFragment;
import com.qiu.neteasemusic.R;
import com.qiu.neteasemusic.Utils.GlideImageLoader;
import com.qiu.neteasemusic.Utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiu on 2017/4/13.
 */

public class FindGroomFragment extends AbstractBaseFragment implements View.OnClickListener{
    private Banner mBanner;
    private Context context;
    private List<Integer> imagesList;
    private TextView tv_detail;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_find_person_groom;
    }

    @Override
    protected void initView(View v) {
        context=getContext();
        mBanner = (Banner) v.findViewById(R.id.banner_find_person);
        tv_detail= (TextView) v.findViewById(R.id.tv_detail);
        imagesList= new ArrayList<>();
        imagesList.add(R.mipmap.first);
        imagesList.add(R.mipmap.second);
        imagesList.add(R.mipmap.third);
        imagesList.add(R.mipmap.fourth);
        imagesList.add(R.mipmap.five);
        imagesList.add(R.mipmap.six);
        imagesList.add(R.mipmap.seven);
        tv_detail.setOnClickListener(this);
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.showToast(context,"点击了="+position);
            }
        });
    }
    @Override
    protected void initData() {
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(imagesList);
        //设置轮播时间
        mBanner.setDelayTime(4000);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.tv_detail){
            ToastUtil.showToast(context,"独家专访");
        }
    }
}
