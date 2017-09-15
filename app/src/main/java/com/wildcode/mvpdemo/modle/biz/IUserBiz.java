package com.wildcode.mvpdemo.modle.biz;

/**
 * Created by 50304 on 2017/9/12.
 */

public interface IUserBiz {
   void login (String username, String password ,OnLoginListener loginListener);
}
