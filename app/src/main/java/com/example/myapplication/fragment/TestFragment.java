package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.interf.NetCallBack2;
import com.example.myapplication.present.TestPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TestFragment extends BaseFragment implements NetCallBack2 {
    @BindView(R.id.fragment_test_textview)
    TextView fragmentTestTextview;

    private Unbinder unbinder;
    @Override
    public TestPresenter getPresenter() {
        return TestPresenter.getInstance();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.testfragment_main, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().registerListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        getPresenter().unregistListerner(this);
    }

    @Override
    public void onSuccessResponed(Object o) {

    }

    @Override
    public void onErrorResponed(Object o) {
        Throwable throwable = (Throwable) o;
        String msg = throwable.getMessage();
        System.out.println("testRx fragment onErrorResponed -----------------------------------------");
        System.out.println(throwable.toString());
    }

    @OnClick(R.id.fragment_test_textview)
    public void onViewClicked() {
        System.out.println("testRx click-----------------------------------------------------------------");
        getPresenter().testRetrofit();
    }
}
