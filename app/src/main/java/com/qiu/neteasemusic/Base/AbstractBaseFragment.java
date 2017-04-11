package com.qiu.neteasemusic.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qiu on 2017/4/11.
 */

public abstract class AbstractBaseFragment extends Fragment {

    protected abstract int getLayoutResId();
    protected abstract void initView(View v);
    protected abstract void initData();
    protected View mView;
    public AbstractBaseFragment() {
        setRetainInstance(true);
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            if (getLayoutResId() == 0)
                return super.onCreateView(inflater, container, savedInstanceState);
            mView = inflater.inflate(getLayoutResId(), container, false);
            initView(mView);
            initData();

        }
        return mView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
