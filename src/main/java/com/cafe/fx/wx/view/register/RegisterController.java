package com.cafe.fx.wx.view.register;

import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.core.FXContext;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

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
        initializeUI();
        initializeEvent();
    }

    /* 初始化UI */
    void initializeUI(){
        form = RegisterForm.getInstance();
        formStackPane.getChildren().add(form.getRenderer());
    }

    /* 初始化事件 */
    void initializeEvent(){

    }

    /* 点击登录事件 */
    public void onLoginClick(ActionEvent actionEvent){
        // System.out.println("当前功能开发中......");
        /* 切换到登录页面 */
        formStackPane.getScene().setRoot(FXComponent.login());
    }

    /* 点击注册事件 */
    public void onRegisterClick(ActionEvent actionEvent){
        // 判断表单是否存在
        form.getForm().persist();

        // 判断表单信息是否合法有效
        if (form.getForm().isValid()){
            FX.info(form.getVo().getUsername() +"注册成功, 欢迎欢迎", FXContext.getLoginStage());
            onLoginClick(actionEvent);
        }
    }

}
