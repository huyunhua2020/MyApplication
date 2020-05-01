package com.example.myapplication.present;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverDemo implements Observer {
    Presenter p;

    public ObserverDemo(Presenter p){
        this.p = p;
    }

    @Override
    public void onSubscribe(Disposable d) {
        p.add(d);
    }

    @Override
    public void onNext(Object o) {
        p.OnSuccess(o);
    }

    @Override
    public void onError(Throwable e) {
        p.OnError(e);
    }

    @Override
    public void onComplete() {

    }



}
