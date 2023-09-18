package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.view.UserDataController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

public class ChatMainController implements UserDataController {

    public Label nicknameLabel;
    public WebView chatWebView;
    public TextArea messageTextArea;

    private Long contactsId;

    @Override
    public void initialize(Object data) {

    }

    void initializeUI(){

    }
    void initializeEvent(){

    }
    void renderDebugDate(){
        nicknameLabel.setText("WxID: " + contactsId);
    }
    public void onClearClick(ActionEvent actionEvent){

    }
    public void onCloseClick(ActionEvent actionEvent){

    }
    public void onSendClick(ActionEvent actionEvent){

    }


}
