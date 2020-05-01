package com.example.myapplication.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyNetService {
    private static long DEFAULT_TIME = 5;
    private static String BASE_URL = "http://192.168.0.1:8082/";
    private static Retrofit retrofit = null;
    private static OkHttpClient client = null;
    static {
        getClient();
        getDefaultApi();

    }
    public static ServiceTestApi getDefaultApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getClient())
                    .build();
        }
        return retrofit.create(ServiceTestApi.class);
    }

    public static  OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
                    .build();
        }
        return client;
    }

}
