package com.qiu.neteasemusic.fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
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

public class FindAnchorDJFragment extends AbstractBaseFragment implements View.OnClickListener {
    private Banner mBanner;
    private Context context;
    private List<Integer> imagesList;
    private TextView tv_detail;
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_find_ganchor_dj;
    }

    @Override
    protected void initView(View v) {
        context=getContext();
        mBanner = (Banner) v.findViewById(R.id.banner_find_dj);
        tv_detail= (TextView) v.findViewById(R.id.tv_detail);
        imagesList= new ArrayList<>();
        imagesList.add(R.mipmap.second);
        imagesList.add(R.mipmap.seven);
        tv_detail.setOnClickListener(this);
        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==1){
                    tv_detail.setText("电台");
                }else{
                    tv_detail.setText("电台节目");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
