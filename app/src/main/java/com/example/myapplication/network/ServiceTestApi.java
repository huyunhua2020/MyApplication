package com.example.myapplication.network;

import com.example.myapplication.bean.RxResponseTest;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceTestApi {
    @GET("/api/test")
    Observable<RxResponseTest> testRetrofit();
}
