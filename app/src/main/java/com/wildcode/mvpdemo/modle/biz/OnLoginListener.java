package com.wildcode.mvpdemo.modle.biz;

import com.wildcode.mvpdemo.modle.bean.User;

/**
 * Created by 50304 on 2017/9/12.
 */

public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
