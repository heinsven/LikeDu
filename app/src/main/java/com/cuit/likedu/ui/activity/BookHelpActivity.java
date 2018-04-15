package com.cuit.likedu.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.cuit.likedu.R;
import com.cuit.likedu.base.BaseCommuniteActivity;
import com.cuit.likedu.component.AppComponent;

import java.util.List;

/**
 * 书荒求助区
 */
public class BookHelpActivity extends BaseCommuniteActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, BookHelpActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_community_book_help;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("书荒互助区");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        super.initDatas();
    }

    @Override
    protected List<List<String>> getTabList() {
        return list1;
    }

    @Override
    public void configViews() {

    }
}
