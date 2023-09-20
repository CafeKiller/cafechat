package com.cafe.fx.wx.caller;

public interface Caller {

    void register(String nickname, String username, String password);

    void login(String username, String password);

    void userinfo(String token);

}
