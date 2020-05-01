package com.example.myapplication.present;

import com.example.myapplication.interf.NetCallBack2;
import com.example.myapplication.network.MyNetManager;

public class TestPresenter extends Presenter {
    private static TestPresenter mTestPresenter;
    private NetCallBack2 callBack2;

    public static TestPresenter getInstance(){
        if (mTestPresenter == null) {
            mTestPresenter = new TestPresenter();
        }
        return mTestPresenter;
    }

    public void registerListener(NetCallBack2 callBack2){
        this.callBack2 = callBack2;
    }
    public void unregistListerner(NetCallBack2 callBack2) {
        if (this.callBack2 == callBack2) {
            this.callBack2 = null;
        }
    }

    @Override
    public void OnSuccess(Object o) {
        callBack2.onSuccessResponed(o);
    }

    @Override
    public void OnError(Object o) {
        System.out.println("testRx Response--------------------------------------");
        callBack2.onErrorResponed(o);
    }

    public void testRetrofit() {
        MyNetManager.getInstance().testRetrofit(new ObserverDemo(this));
    }

}
