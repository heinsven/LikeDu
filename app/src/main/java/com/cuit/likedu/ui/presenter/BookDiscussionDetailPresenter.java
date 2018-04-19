package com.cuit.likedu.ui.presenter;

import com.cuit.likedu.api.BookApi;
import com.cuit.likedu.base.RxPresenter;
import com.cuit.likedu.bean.CommentList;
import com.cuit.likedu.bean.Disscussion;
import com.cuit.likedu.ui.contract.BookDiscussionDetailContract;
import com.cuit.likedu.utils.LogUtils;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookDiscussionDetailPresenter extends RxPresenter<BookDiscussionDetailContract.View> implements BookDiscussionDetailContract.Presenter {

    private BookApi bookApi;

    @Inject
    public BookDiscussionDetailPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookDisscussionDetail(String id) {
        Subscription rxSubscription = bookApi.getBookDisscussionDetail(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Disscussion>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionDetail:" + e.toString());
                    }

                    @Override
                    public void onNext(Disscussion disscussion) {
                        mView.showBookDisscussionDetail(disscussion);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBestComments(String disscussionId) {
        Subscription rxSubscription = bookApi.getBestComments(disscussionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBestComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBestComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBookDisscussionComments(String disscussionId, int start, int limit) {
        Subscription rxSubscription = bookApi.getBookDisscussionComments(disscussionId, start + "", limit + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBookDisscussionComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
