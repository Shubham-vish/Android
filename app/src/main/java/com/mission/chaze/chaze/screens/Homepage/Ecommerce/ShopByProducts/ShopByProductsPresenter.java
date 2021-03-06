

package com.mission.chaze.chaze.screens.Homepage.Ecommerce.ShopByProducts;

import android.support.v7.widget.RecyclerView;

import com.mission.chaze.chaze.models.EcomerceCategory;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.screens.base.BasePresenter;
import com.mission.chaze.chaze.utils.rx.SchedulerProvider;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import timber.log.Timber;


/**
 * Created by Shubham Vishwakarma on 12/10/18.
 */

public class ShopByProductsPresenter<V extends ShopByProductsContract.View> extends BasePresenter<V>
        implements ShopByProductsContract.Presentor<V> {


    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private int pageNumber;

    @Inject
    public ShopByProductsPresenter(ICommonAPIManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }



    public void next(){
        pageNumber++;
        paginator.onNext(pageNumber);
    }

    /**
     * subscribing for data
     */
    public void subscribeForData() {

        Disposable disposable = paginator
                .onBackpressureDrop()
                .concatMap((Function<Integer, Publisher<List<EcomerceCategory>>>) page -> {

                    getMvpView().showLoading();
                    return dataFromNetwork(page);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    getMvpView().addItems(items);
                    getMvpView().hideLoading();
                });

        getCompositeDisposable().add(disposable);

       next();

    }


    /**
     * Simulation of network data
     */
    private Flowable<List<EcomerceCategory>> dataFromNetwork(final int page) {
        Timber.e("" + page);
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> {
                    List<EcomerceCategory> items = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        items.add(new EcomerceCategory("Item " + (page * 10 + i), "asdf","https://drive.google.com/file/d/15b68H448F4jszurUpAAQV6lFPHdY1dv2/view?usp=sharing"));
                    }
                    return items;
                });
    }


}
