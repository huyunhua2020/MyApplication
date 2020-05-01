package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.fragment.TestFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.textView2)
    TextView textView2;

    private FragmentManager fragmentManager;
    private Fragment testFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testactivity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        testFragment = new TestFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragment, testFragment,"f1")
                .show(testFragment)
                .commit();
    }


    @OnClick({R.id.fragment, R.id.textView2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragment:
                break;
            case R.id.textView2:
                String text = textView2.getText().toString();
                if (text.startsWith("show")){
                    textView2.setText("off fragment");
                    fragmentManager.beginTransaction()
                            .show(testFragment)
                            .commit();
                } else {
                    fragmentManager.beginTransaction()
                            .hide(testFragment)
                             .commit();
                    textView2.setText("show fragment");
                }
                break;
        }
    }
}
