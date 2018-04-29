package com.cuit.likedu.ui.contract;

import com.cuit.likedu.base.BaseContract;
import com.cuit.likedu.bean.DiscussionList;

import java.util.List;

public interface BookDiscussionContract {

    interface View extends BaseContract.BaseView {
        void showBookDisscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookDisscussionList(String block, String sort, String distillate, int start, int limit);
    }

}
