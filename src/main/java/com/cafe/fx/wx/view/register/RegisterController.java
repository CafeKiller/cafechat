package com.cafe.fx.wx.view.register;

import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXContext;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

/* 注册表单处理器 */
public class RegisterController implements Initializable {
    /* 关联表单 */
    public StackPane formStackPane;
    private RegisterForm form;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /* 初始化UI */
    void initializeUI(){
        form = RegisterForm.getInstance();
        formStackPane.getChildren().add(form.getRenderer());
    }

    /* 初始化事件 */
    void initializeEvent(){

    }

    public void onLoginClick(ActionEvent actionEvent){
        System.out.println("当前功能开发中......");
    }

    public void onRegisterClick(ActionEvent actionEvent){
        form.getForm().persist();

        if (form.getForm().isValid()){
            FX.info(form.getVo().getUsername() +"注册成功, 欢迎欢迎");
        }
    }

}
