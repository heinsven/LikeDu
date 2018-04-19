package com.cuit.likedu.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cuit.likedu.R;
import com.cuit.likedu.base.BaseFragment;
import com.cuit.likedu.bean.support.FindBean;
import com.cuit.likedu.common.OnRvItemClickListener;
import com.cuit.likedu.component.AppComponent;
import com.cuit.likedu.ui.activity.TopCategoryListActivity;
import com.cuit.likedu.ui.activity.TopRankActivity;
import com.cuit.likedu.ui.adapter.FindAdapter;
import com.cuit.likedu.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 发现
 */
public class FindFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private FindAdapter mAdapter;
    private List<FindBean> mList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initDatas() {
        mList.clear();
        mList.add(new FindBean("排行榜", R.drawable.home_find_rank));
        mList.add(new FindBean("分类", R.drawable.home_find_category));
    }

    @Override
    public void configViews() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));

        mAdapter = new FindAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void attachView() {

    }

    @Override
    public void onItemClick(View view, int position, FindBean data) {
        switch (position) {
            case 0:
                TopRankActivity.startActivity(activity);
                break;
            case 1:
                startActivity(new Intent(activity, TopCategoryListActivity.class));
                break;
            default:
                break;
        }
    }

}
