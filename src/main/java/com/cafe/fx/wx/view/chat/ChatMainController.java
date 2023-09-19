package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.html.Html;
import com.cafe.fx.wx.view.UserDataController;
import com.cafe.fx.wx.vo.MessageVO;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyCode;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.util.Date;
import java.util.Objects;

public class ChatMainController implements UserDataController {

    public Label nicknameLabel;
    public WebView chatWebView;
    public TextArea messageTextArea;

    private JSObject js;
    private Long contactsId;


    @Override
    public void initialize(Object data) {
        contactsId = (Long)data;
        initializeUI();
        initializeEvent();
    }

    void initializeUI(){
        chatWebView.setContextMenuEnabled(false);
        chatWebView.setBlendMode(BlendMode.DARKEN);
        WebEngine engine = chatWebView.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.getLoadWorker().stateProperty().addListener((obj, ov, nv)->{
            if (nv == Worker.State.SUCCEEDED){
                js = (JSObject)engine.executeScript("window.main");
                renderDebugDate();
            }
        });
        engine.load(Objects.requireNonNull(getClass().getResource("/html/main.html")).toExternalForm());
    }
    void initializeEvent(){
        messageTextArea.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.ENTER){
                onSendClick(null);
            }
        });
    }
    void renderDebugDate(){
        nicknameLabel.setText("WxID: " + contactsId);
        MessageVO from = new MessageVO();
        from.setNickname("ATX_wuying");
        from.setMessage("HELLO 我是ATX_wuying");
        from.setTimestamp(new Date().getTime());
        append(from, true);
    }

    void append(MessageVO vo, boolean isContacts){
        js.call("append", Html.of(vo.getNickname(), vo.getTimestamp(), vo.getMessage(), isContacts));
    }

    public void onClearClick(ActionEvent actionEvent){
        js.call("clear");
    }
    public void onCloseClick(ActionEvent actionEvent){

    }
    public void onSendClick(ActionEvent actionEvent){
        String content = messageTextArea.getText();
        if (content.trim().length() == 0){
            return;
        }

        MessageVO from = new MessageVO();
        from.setNickname("My");
        from.setMessage(content);
        from.setTimestamp(new Date().getTime());
        append(from, false);
        messageTextArea.clear();
    }


}
