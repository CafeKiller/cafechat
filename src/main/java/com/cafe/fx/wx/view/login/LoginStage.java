package com.cafe.fx.wx.view.login;

import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.core.FXIcon;
import javafx.stage.Stage;

public class LoginStage extends Stage {

    private LoginStage(){

    }

    public static LoginStage build(){
        LoginStage stage = new LoginStage();
        stage.setTitle("CAFE Chat bate");

        /* 设置Login页面参数 */
        stage.getIcons().clear();
        stage.getIcons().add(FXIcon.logo());
        stage.setWidth(450);
        stage.setHeight(350);
        stage.initOwner(FXContext.getPrimaryStage());

        return stage;
    }



}
