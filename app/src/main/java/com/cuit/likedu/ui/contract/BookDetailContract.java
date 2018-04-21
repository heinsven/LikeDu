package com.cuit.likedu.ui.contract;

import com.cuit.likedu.base.BaseContract;
import com.cuit.likedu.bean.BookDetail;
import com.cuit.likedu.bean.HotReview;

import java.util.List;

public interface BookDetailContract {

    interface View extends BaseContract.BaseView {
        void showBookDetail(BookDetail data);

        void showHotReview(List<HotReview.Reviews> list);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookDetail(String bookId);

        void getHotReview(String book);

    }

}
