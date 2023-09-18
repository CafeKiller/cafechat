package com.cafe.fx.wx.core;

import com.cafe.fx.wx.view.chat.ChatListController;
import com.cafe.fx.wx.view.contacts.ContactsListController;
import com.cafe.fx.wx.view.contacts.ContactsProfileController;
import com.cafe.fx.wx.view.login.LoginController;
import com.cafe.fx.wx.view.register.RegisterController;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

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

    public static Pane mainComponent(){
        return  (Pane)cache.computeIfAbsent("mainComponent",k -> (Parent) FXContext.getPrimaryStage().getScene().lookup("#mainPane"));
    }

    public static Parent contactsProfileComponent(Long id){
        return FX.fxml(ContactsProfileController.class, id);
    }

    /*public static Parent chatMainComponent(Long id){
        return FX.fxml()
    }*/
}
