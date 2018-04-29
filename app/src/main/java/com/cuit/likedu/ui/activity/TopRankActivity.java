package com.cuit.likedu.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;

import com.cuit.likedu.R;
import com.cuit.likedu.base.BaseActivity;
import com.cuit.likedu.bean.RankingList;
import com.cuit.likedu.common.OnRvItemClickListener;
import com.cuit.likedu.component.AppComponent;
import com.cuit.likedu.component.DaggerFindComponent;
import com.cuit.likedu.ui.adapter.TopRankAdapter;
import com.cuit.likedu.ui.contract.TopRankContract;
import com.cuit.likedu.ui.presenter.TopRankPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class TopRankActivity extends BaseActivity implements TopRankContract.View {

    @Bind(R.id.elvMale)
    ExpandableListView elvMale;

    private List<RankingList.MaleBean> maleGroups = new ArrayList<>();
    private List<List<RankingList.MaleBean>> maleChilds = new ArrayList<>();
    private TopRankAdapter maleAdapter;

    @Inject
    TopRankPresenter mPresenter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TopRankActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_top_rank;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("排行榜");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        maleAdapter = new TopRankAdapter(this, maleGroups, maleChilds);
        maleAdapter.setItemClickListener(new ClickListener());
    }

    @Override
    public void configViews() {
        showDialog();
        elvMale.setAdapter(maleAdapter);

        mPresenter.attachView(this);
        mPresenter.getRankList();
    }

    @Override
    public void showRankList(RankingList rankingList) {
        maleGroups.clear();
        updateMale(rankingList);
    }

    private void updateMale(RankingList rankingList) {
        List<RankingList.MaleBean> list = rankingList.male;
        List<RankingList.MaleBean> collapse = new ArrayList<>();
        for (RankingList.MaleBean bean : list) {
            if (bean.collapse) { // 折叠
                collapse.add(bean);
            } else {
                maleGroups.add(bean);
                maleChilds.add(new ArrayList<RankingList.MaleBean>());
            }
        }
        maleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        dismissDialog();
    }

    class ClickListener implements OnRvItemClickListener<RankingList.MaleBean> {

        @Override
        public void onItemClick(View view, int position, RankingList.MaleBean data) {
            SubRankActivity.startActivity(mContext, data._id, data.monthRank, data.totalRank, data.title);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
