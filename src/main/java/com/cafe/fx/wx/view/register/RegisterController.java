package com.cafe.fx.wx.view.register;

import com.cafe.fx.wx.core.FX;
import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.event.Event;
import com.cafe.fx.wx.event.EventDispatcher;
import com.cafe.fx.wx.event.data.RegisterDTO;
import com.cafe.fx.wx.vo.RegisterVO;
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
        EventDispatcher.register(Event.REGISTER, data ->{
            RegisterDTO r = (RegisterDTO) data;
            FX.info(r.getUsername() + "注册成功", FXContext.getLoginStage());
            onLoginClick(null);
        }, FXContext.getLoginStage());
    }

    /* 点击登录事件 */
    public void onLoginClick(ActionEvent actionEvent){
        // System.out.println("当前功能开发中......");
        /* 切换到登录页面 */
        formStackPane.getScene().setRoot(FXComponent.login());
    }

    /* 点击注册事件 */
    public void onRegisterClick(ActionEvent actionEvent){
        // 获取并保存表单的值
        form.getForm().persist();

        // 判断表单中的值是否有效且合法
        if (form.getForm().isValid()){
            /*FX.info(form.getVo().getUsername() +"注册成功, 欢迎欢迎", FXContext.getLoginStage());
            onLoginClick(actionEvent);*/
            RegisterVO r = form.getVo();
            FXContext.getCaller().register(r.getNickname(), r.getUsername(), r.getPassword());
        }
    }

}
