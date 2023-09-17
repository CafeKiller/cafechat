package com.cafe.fx.wx.core;

import com.cafe.fx.wx.view.chat.ChatListController;
import com.cafe.fx.wx.view.contacts.ContactsListController;
import com.cafe.fx.wx.view.login.LoginController;
import com.cafe.fx.wx.view.register.RegisterController;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.util.HashMap;
import java.util.Map;

/* 组件管理对象 */
public class FXComponent {

    private static final Map<String, Parent> cache = new HashMap<>();


    public static Parent login(){
        return cache.computeIfAbsent("login", k -> FX.fxml(LoginController.class));
    }

    public static Parent register(){
        return cache.computeIfAbsent("register", k -> FX.fxml(RegisterController.class));
    }

    public static Parent chatListController(){
        return cache.computeIfAbsent("chatListController",k -> FX.fxml(ChatListController.class));
    }

    public static Parent contactsListController(){
        return cache.computeIfAbsent("contactsListController",k -> FX.fxml(ContactsListController.class));
    }
}
