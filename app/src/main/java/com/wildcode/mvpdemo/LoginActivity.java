package com.wildcode.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wildcode.mvpdemo.modle.bean.User;
import com.wildcode.mvpdemo.presenter.UserLoginPresenter;
import com.wildcode.mvpdemo.view.IUserLoginView;

public class LoginActivity extends Activity implements View.OnClickListener, IUserLoginView {

    private EditText mEt_username;
    private EditText mEt_password;
    private Button mBt_clear;
    private Button mBt_login;
    private ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initView();
    }

    private void initView() {
        mEt_username = (EditText) findViewById(R.id.et_login_username);
        mEt_password = (EditText) findViewById(R.id.et_login_password);
        mBt_clear = (Button) findViewById(R.id.btn_clear);
        mBt_login = (Button) findViewById(R.id.btn_login);
        mPbLoading = (ProgressBar) findViewById(R.id.progress);

        mBt_clear.setOnClickListener(this);
        mBt_login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear:
                mUserLoginPresenter.clear();
                break;
            case R.id.btn_login:
                mUserLoginPresenter.login();
                break;
        }
    }

    @Override
    public String getUserName() {
        return mEt_username.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEt_password.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEt_username.setText("");
    }

    @Override
    public void clearPassWord() {
        mEt_password.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"login failed",Toast.LENGTH_SHORT).show();
    }
}
