package com.cafe.fx.wx.core;

import com.cafe.fx.wx.caller.Caller;
import com.cafe.fx.wx.view.login.LoginStage;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


/* FX上下文容器管理对象 */
public class FXContext {

    private static final Map<String, Object> cache = new HashMap<>();

    private static <T> T get(String key){
        return (T) cache.get(key);
    }
    private static void put(String key, Object value){
        cache.put(key, value);
    }

    interface K {
        String PRIMARY_STAGE = "PRIMARY_STAGE";
        String LOGIN_STAGE = "LOGIN_STAGE";
        String CALLER = "CALLER";
    }

    public static Stage getPrimaryStage(){
        return get(K.PRIMARY_STAGE);
    }

    public static void setPrimaryStage(Stage primaryStage){
        put(K.PRIMARY_STAGE, primaryStage);
    }

    public static Stage getLoginStage(){
        return get(K.LOGIN_STAGE);
    }

    public static void setLoginStage(LoginStage loginStage){
        put(K.LOGIN_STAGE, loginStage);
    }

    public static Caller getCaller(){
        return get(K.CALLER);
    }
    public static void setCaller(Caller caller){
        put(K.CALLER, caller);
    }

}
