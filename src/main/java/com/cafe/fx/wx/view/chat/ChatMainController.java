package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.html.Html;
import com.cafe.fx.wx.view.UserDataController;
import com.cafe.fx.wx.vo.MessageVO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.util.Date;

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

    }
    void initializeEvent(){

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
