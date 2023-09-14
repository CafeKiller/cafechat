package com.cafe.fx.wx.view.login;

import javafx.stage.Stage;

public class LoginStage extends Stage {

    private LoginStage(){

    }

    public static LoginStage build(){
        LoginStage stage = new LoginStage();
        stage.setTitle("CAFE Chat bate");

        return stage;
    }



}
