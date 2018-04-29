package com.cuit.likedu.ui.presenter;

import com.cuit.likedu.api.BookApi;
import com.cuit.likedu.base.RxPresenter;
import com.cuit.likedu.bean.RankingList;
import com.cuit.likedu.ui.contract.TopRankContract;
import com.cuit.likedu.utils.LogUtils;
import com.cuit.likedu.utils.RxUtil;
import com.cuit.likedu.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class TopRankPresenter extends RxPresenter<TopRankContract.View> implements TopRankContract.Presenter<TopRankContract.View> {

    private BookApi bookApi;

    @Inject
    public TopRankPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getRankList() {
        String key = StringUtils.creatAcacheKey("book-ranking-list");
        Observable<RankingList> fromNetWork = bookApi.getRanking()
                .compose(RxUtil.<RankingList>rxCacheBeanHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, RankingList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RankingList>() {
                    @Override
                    public void onNext(RankingList data) {
                        if (data != null && mView != null) {
                            mView.showRankList(data);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRankList:" + e.toString());
                        mView.complete();
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
