package com.cui.mrr.presenter.iml;

import com.cui.mrr.entity.ListEntity;
import com.cui.mrr.http.ApiClient;
import com.cui.mrr.ui.MainActivity;
import com.cui.mrr.view.iml.MainContract;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cuiyang on 16/6/20.
 */
public class MainPreseneter extends SavePresenter implements MainContract.MainPresenterIml {

    private MainActivity activity;
    private MainContract.MainView mView;

    public MainPreseneter(MainActivity activity) {
        this.activity = activity;
        this.mView = activity;
    }

    @Override
    public Subscription getMainListData() {
        subscription = ApiClient.getApiService()
                .getMainList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(entity -> mView.getListData((List<ListEntity>) entity),
                        throwable -> mView.refreshError(throwable.getMessage()));
        return subscription;
    }

    @Override
    public Subscription downLoadFile(String url) {
        return super.savePicture(url, activity);
    }
}
