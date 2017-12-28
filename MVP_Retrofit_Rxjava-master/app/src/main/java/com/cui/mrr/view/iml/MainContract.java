package com.cui.mrr.view.iml;

import com.cui.mrr.entity.ListEntity;
import com.cui.mrr.view.BaseContract;

import java.util.List;

import rx.Subscription;

/**
 * Created by cuiyang on 16/6/20.
 */
public interface MainContract {
    interface MainView extends BaseContract.BaseView {

        void DownLoadSuccesss(boolean isSuccess);

        void getListData(List<ListEntity> entity);
    }

    interface MainPresenterIml extends BaseContract.BasePresenter {
        Subscription getMainListData();

        Subscription downLoadFile(String url);
    }
}
