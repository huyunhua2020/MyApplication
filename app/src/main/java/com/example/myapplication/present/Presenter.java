package com.example.myapplication.present;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class Presenter<V> {
    public V view;
    public CompositeDisposable compositeDisposable;
    //public abstract void subscribe();
    //public abstract void unSubcrebe();

    public void onAttach(V view) {
        this.view = view;
    }

    public void onDettach() {
        if (view != null) {
            this.view = null;
        }
        if(compositeDisposable != null) {
            compositeDisposable.clear();
        }

    }

    public synchronized void add(Disposable d){
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            compositeDisposable.add(d);
        }
    }

    public abstract void OnSuccess(Object o);
    public abstract void OnError(Object o);

}
