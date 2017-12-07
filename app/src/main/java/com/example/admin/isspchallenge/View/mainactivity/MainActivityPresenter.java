package com.example.admin.isspchallenge.view.mainactivity;

import com.example.admin.isspchallenge.datasource.RetrofitHelper;
import com.example.admin.isspchallenge.model.ResultClass;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 12/6/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter{
    MainActivityContract.View mView;
    @Override
    public void attach(MainActivityContract.View View) {
        this.mView = View;
    }

    @Override
    public void detach() {
        this.mView = null;
    }

    @Override
    public void getPermission() {
        mView.getLocationPermission();
    }

    @Override
    public void getLocationCoord() {
        mView.getLocation();
    }

    @Override
    public void getResults(String Lat, String Long) {
        retrofit2.Call<ResultClass> getResult = RetrofitHelper.getResults(Lat,Long);
        getResult.enqueue(new Callback<ResultClass>() {
            @Override
            public void onResponse(retrofit2.Call<ResultClass> call, Response<ResultClass> response) {
                mView.ShowRecyclerView(response.body().getResponse());
            }

            @Override
            public void onFailure(retrofit2.Call<ResultClass> call, Throwable t) {
                mView.showError(t.getMessage());
            }
        });
    }

    @Override
    public boolean CheckInternetConnection() {
        return mView.isNetworkAvailable();
    }


}
