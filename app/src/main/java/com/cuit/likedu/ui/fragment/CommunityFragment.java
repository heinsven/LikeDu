package com.cuit.likedu.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cuit.likedu.R;
import com.cuit.likedu.base.BaseFragment;
import com.cuit.likedu.bean.support.FindBean;
import com.cuit.likedu.common.OnRvItemClickListener;
import com.cuit.likedu.component.AppComponent;
import com.cuit.likedu.ui.activity.BookDiscussionActivity;
import com.cuit.likedu.ui.activity.BookReviewActivity;
import com.cuit.likedu.ui.adapter.FindAdapter;
import com.cuit.likedu.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CommunityFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {

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
        mList.add(new FindBean("综合讨论区", R.drawable.discuss_section));
        mList.add(new FindBean("书评区", R.drawable.comment_section));
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
                BookDiscussionActivity.startActivity(activity,true);
                break;
            case 1:
                BookReviewActivity.startActivity(activity);
                break;
            default:
                break;
        }
    }

}
