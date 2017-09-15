package com.wildcode.mvpdemo.presenter;

import android.os.Handler;

import com.wildcode.mvpdemo.modle.bean.User;
import com.wildcode.mvpdemo.modle.biz.IUserBiz;
import com.wildcode.mvpdemo.modle.biz.OnLoginListener;
import com.wildcode.mvpdemo.modle.biz.UserBiz;
import com.wildcode.mvpdemo.view.IUserLoginView;

/**
 * Created by 50304 on 2017/9/12.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;                       //model对象链接成功与否
    private IUserLoginView userLoginView;           //view接口
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }


    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(),userLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }
    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassWord();
    }
}
