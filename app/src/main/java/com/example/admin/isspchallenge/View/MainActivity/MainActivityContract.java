package com.example.admin.isspchallenge.View.MainActivity;

import com.example.admin.isspchallenge.BasePresenter;
import com.example.admin.isspchallenge.BaseView;
import com.example.admin.isspchallenge.model.Response;

import java.util.List;

/**
 * Created by Admin on 12/6/2017.
 */

public interface MainActivityContract {

    interface view extends BaseView{
        void getLocationPermission();
        void getLocation();
        void ShowRecyclerView(List<Response> responsesList);
        boolean isNetworkAvailable();
    }
    interface Presenter extends BasePresenter<view>{
        void getPermission();
        void getLocationCoord();
        void getResults(String Lat, String Long);
        boolean CheckInternetConnection();
    }
}
