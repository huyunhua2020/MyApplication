package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.present.Presenter;

public abstract class BaseFragment<T extends Presenter> extends Fragment {

    public abstract T getPresenter();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onAttach(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDettach();
    }
}
