package com.wildcode.mvpdemo.modle.biz;

import com.wildcode.mvpdemo.modle.bean.User;

/**
 * Created by 50304 on 2017/9/12.
 */

public class UserBiz implements IUserBiz {
    //联网核对账号密码逻辑
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if ("cl".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setUserName(username);
                    user.setPassWord(password);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
