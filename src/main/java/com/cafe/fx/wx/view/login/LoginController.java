package com.cafe.fx.wx.view.login;

import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.event.Event;
import com.cafe.fx.wx.event.EventDispatcher;
import com.cafe.fx.wx.event.data.LoginDTO;
import com.cafe.fx.wx.vo.LoginVO;
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
        EventDispatcher.register(Event.LOGIN, data -> {
            LoginDTO r = (LoginDTO) data;
             FXContext.getCaller().userinfo(r.getToken());
             FXContext.getLoginStage().close();
             FXContext.getPrimaryStage().show();
        }, FXContext.getLoginStage());
    }

    public void onRegisterClick(ActionEvent actionEvent){
        /* 切换到注册页面 */
        formStackPane.getScene().setRoot(FXComponent.register());
    }

    public void onLoginClick(ActionEvent actionEvent){
        // 获取并保存表单的值
        form.getForm().persist();

        // 判断表单中的值是否有效且合法
        if (form.getForm().isValid()){
            /* 关闭当前登录页面, 同时打开主页面 */
            /*FXContext.getLoginStage().close();
            FXContext.getPrimaryStage().show();*/
            LoginVO r = form.getVo();
            FXContext.getCaller().login(r.getUsername(), r.getPassword());
        }
    }

}
