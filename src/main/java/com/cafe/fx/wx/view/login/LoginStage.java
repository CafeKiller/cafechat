package com.cafe.fx.wx.view.login;

import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.core.FXContext;
import com.cafe.fx.wx.core.FXIcon;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginStage extends Stage {

    private LoginStage(){

    }

    public static LoginStage build(){
        LoginStage stage = new LoginStage();
        stage.setTitle("CAFE Chat bate");

        stage.setScene(new Scene(FXComponent.login()));

        // 判断平台是否支持 EFFECT 效果, 若支持则初始化为unified样式(即无样式)
//        if (Platform.isSupported(ConditionalFeature.EFFECT)){
//            stage.initStyle(StageStyle.UNIFIED);
//        }

        /* 设置Login页面参数 */
        stage.getIcons().clear();
        stage.getIcons().add(FXIcon.logo());
        stage.setWidth(450);
        stage.setHeight(350);
        stage.initOwner(FXContext.getPrimaryStage());

        return stage;
    }



}
