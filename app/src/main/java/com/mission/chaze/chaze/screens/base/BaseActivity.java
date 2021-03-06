

package com.mission.chaze.chaze.screens.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.mission.chaze.chaze.AppController;
import com.mission.chaze.chaze.di.component.ActivityComponent;
import com.mission.chaze.chaze.di.component.DaggerActivityComponent;
import com.mission.chaze.chaze.di.module.ActivityModule;

import butterknife.Unbinder;


/**
 * Created by Shubham Vishwakarma on 4/10/18.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpContract.View {


    ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    ProgressDialog progressDialog;


    @Override
    protected void onPause() {
        super.onPause();
        progressDialog.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((AppController) getApplication()).getComponent())
                .build();

         progressDialog = new ProgressDialog(getApplicationContext());

    }

    public void onAttach(Context c) {
        progressDialog = new ProgressDialog(c);
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.hide();
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

}
