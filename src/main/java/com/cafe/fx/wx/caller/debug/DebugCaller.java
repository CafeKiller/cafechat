package com.cafe.fx.wx.caller.debug;

import com.cafe.fx.wx.constant.IMCode;
import com.cafe.fx.wx.event.Event;
import com.cafe.fx.wx.event.EventDispatcher;
import com.cafe.fx.wx.event.data.RegisterDTO;
import com.cafe.fx.wx.vo.RegisterVO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DebugCaller {

    private final Map<String, UserData> userDB = new ConcurrentHashMap<>();
    private final Map<Long, String> tokentCache = new ConcurrentHashMap<>();

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

}
