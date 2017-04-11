package com.qiu.neteasemusic.Base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.qiu.neteasemusic.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by qiu on 2017/4/11.
 * activity的基类
 */

public abstract class BaseToolbarActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private TextView toolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initStauteBar();
        initBase();
        initView();

    }

    private void initBase() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //是否显示toolbar 自带title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        if(isDisplayHomeAsUpEnabled()){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.base_nav_back_icon);
        }
        toolbarTitle = (TextView) toolbar.findViewById(R.id.nav_toolbar_title);
        toolbarTitle.setText(getToolbarTitle());
        toolbarTitle.setOnClickListener(this);
        //返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 是否显示返回键
     *
     * @return
     */
    abstract protected boolean isDisplayHomeAsUpEnabled();

    protected Toolbar getToolbar(){
        return toolbar;
    }
    protected abstract int getLayoutResId();

    private void initStauteBar() {
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.TRANSPARENT);
    }
    abstract protected void initView();
    abstract protected String getToolbarTitle();
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }

}
