package com.cafe.fx.wx.caller.debug;

import com.cafe.fx.wx.caller.Caller;
import com.cafe.fx.wx.constant.IMCode;
import com.cafe.fx.wx.event.Event;
import com.cafe.fx.wx.event.EventDispatcher;
import com.cafe.fx.wx.event.data.LoginDTO;
import com.cafe.fx.wx.event.data.RegisterDTO;
import com.cafe.fx.wx.vo.RegisterVO;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

public class DebugCaller implements Caller {

    private final Map<String, UserData> userDB = new ConcurrentHashMap<>();
    private final Map<Long, String> tokenCache = new ConcurrentHashMap<>();

    @Override
    public void register(String nickname, String username, String password){
        if (userDB.containsKey(username)){
            EventDispatcher.dispatch(Event.REGISTER, IMCode.REGISTER__USERNAME_ALREADY_EXISTS,"账号已被注册");
        } else {
            UserData user = new UserData();
            user.setId((long)userDB.size());
            user.setNickname(nickname);
            user.setUsername(username);
            user.setPassword(password);
            userDB.put(username, user);

            RegisterDTO data = new RegisterDTO();
            data.setUsername(username);
            EventDispatcher.dispatch(Event.REGISTER, data);
        }
    }

    @Override
    public void login(String username, String password) {
        UserData user = userDB.get(username);
        if (Objects.isNull(user) || !Objects.equals(user.getPassword(), password)){
            EventDispatcher.dispatch(Event.LOGIN, IMCode.LOGIN__USERNAME_OR_PASSWORD_ERROR, "账号密码不匹配");
        } else {
            StringJoiner sj = new StringJoiner(":");
            sj.add(String.valueOf(user.getId()));
            sj.add(String.valueOf(System.currentTimeMillis()));
            sj.add(username);

            LoginDTO data = new LoginDTO();
            data.setId(user.getId());
            data.setToken(sj.toString());
            tokenCache.put(data.getId(), data.getToken());
            EventDispatcher.dispatch(Event.LOGIN, data);
        }
    }



    @Override
    public void userinfo(String token) {

    }



}
