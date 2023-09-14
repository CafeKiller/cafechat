package com.cafe.fx.wx.view.login;

import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.core.FXContext;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;


/* 登录页面控制器 */
public class LoginController implements Initializable {

    public StackPane formStackPane;
    public LoginForm form;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeUI();
        initializeEvent();
    }

    /* 初始化UI页面 */
    void initializeUI(){
        form = LoginForm.getInstance();
        formStackPane.getChildren().add(form.getRenderer());
    }

    /* 初始化事件 */
    void initializeEvent(){

    }

    public void onRegisterClick(ActionEvent actionEvent){
        /* 切换到注册页面 */
        formStackPane.getScene().setRoot(FXComponent.register());
    }

    public void onLoginClick(ActionEvent actionEvent){
        form.getForm().persist();
        if (form.getForm().isValid()){
            /* 关闭当前登录页面, 同时打开主页面 */
            FXContext.getLoginStage().close();
            FXContext.getPrimaryStage().show();
        }
    }

}
