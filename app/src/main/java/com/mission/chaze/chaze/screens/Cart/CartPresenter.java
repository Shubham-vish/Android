

package com.mission.chaze.chaze.screens.Cart;

import android.widget.Toast;

import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class CartPresenter<V extends CartContract.View> extends BasePresenter<V>
        implements CartContract.Presentor<V> {

    PublishSubject<String> subject;

    @Inject
    public CartPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        subject = PublishSubject.create();

        getMvpView().setSubjectToAdapter(subject);


        subject.subscribe((str)-> getMvpView().showFull(str));

    }

    @Override
    public void show() {

        getMvpView().showOnActivity();

    }
}
