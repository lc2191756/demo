package com.wildcode.mvpdemo.view;

import com.wildcode.mvpdemo.modle.bean.User;

/**
 * Created by 50304 on 2017/9/12.
 */

public interface IUserLoginView {
    String getUserName();           //获取账号
    String getPassWord();           //获取密码
    void clearUserName();           //清空账号
    void clearPassWord();           //清空密码
    void showLoading();             //显示加载界面
    void hideLoading();             //隐藏加载界面
    void toMainActivity(User user); //带着user数据去首页
    void showFailedError();         //显示错误


}
