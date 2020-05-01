package com.example.myapplication.network;

import com.example.myapplication.present.ObserverDemo;
import com.example.myapplication.present.Presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyNetManager {
    private static Object lock = new Object();
    private static MyNetManager myNetManager;
    public static MyNetManager getInstance() {
        synchronized (lock) {
            if (myNetManager == null) {
                myNetManager = new MyNetManager();
            }
        }
        return myNetManager;
    }

    public void testRetrofit(ObserverDemo observerDemo) {
        System.out.println("testRx testRetrofit-----------------------------------------");
        requestHandle(MyNetService.getDefaultApi().testRetrofit(),observerDemo);
    }

    public void requestHandle(Observable observable, Observer observer){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
