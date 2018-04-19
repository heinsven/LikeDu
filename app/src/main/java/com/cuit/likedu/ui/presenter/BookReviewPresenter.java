package com.cuit.likedu.ui.presenter;

import com.cuit.likedu.api.BookApi;
import com.cuit.likedu.base.RxPresenter;
import com.cuit.likedu.bean.BookReviewList;
import com.cuit.likedu.ui.contract.BookReviewContract;
import com.cuit.likedu.utils.LogUtils;
import com.cuit.likedu.utils.RxUtil;
import com.cuit.likedu.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class BookReviewPresenter extends RxPresenter<BookReviewContract.View> implements BookReviewContract.Presenter {

    private BookApi bookApi;

    @Inject
    public BookReviewPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookReviewList(final String sort, final String type, final String distillate, final int start, final int limit) {
        String key = StringUtils.creatAcacheKey("book-review-list", sort, type, distillate, start, limit);
        Observable<BookReviewList> fromNetWork = bookApi.getBookReviewList("all", sort, type, start + "", limit + "", distillate)
                .compose(RxUtil.<BookReviewList>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BookReviewList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookReviewList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError: "+e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookReviewList list) {
                        LogUtils.d("onNext: get data finish");
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showBookReviewList(list.reviews, isRefresh);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
