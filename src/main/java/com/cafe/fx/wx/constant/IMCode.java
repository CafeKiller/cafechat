package com.cafe.fx.wx.constant;

public interface IMCode {

    int OK = 0;

    /* 注册: 账号已被注册 */
    int REGISTER__USERNAME_ALREADY_EXISTS = 10001;

    /* 登录: 账号密码不匹配 */
    int LOGIN__USERNAME_OR_PASSWORD_ERROR = 10002;

    /* 会话: 令牌已失效 */
    int SESSION_TOKEN_INVALID = 10003;

}
