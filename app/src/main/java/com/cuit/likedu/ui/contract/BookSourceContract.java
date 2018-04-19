package com.cuit.likedu.ui.contract;

import com.cuit.likedu.base.BaseContract;
import com.cuit.likedu.bean.BookSource;

import java.util.List;

public interface BookSourceContract {

    interface View extends BaseContract.BaseView {
        void showBookSource(List<BookSource> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookSource(String view, String book);
    }

}
