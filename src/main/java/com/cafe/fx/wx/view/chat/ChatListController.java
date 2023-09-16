package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.constant.MessageSource;
import com.cafe.fx.wx.vo.MessageVO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ChatListController implements Initializable {

    public ListView<MessageVO> chatListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeUI();
        initializeEvent();
        renderDebugDate();
    }
    public void initializeUI(){
        chatListView.setCellFactory(f -> new ChatRowController());
    }
    public void initializeEvent(){

    }

    void renderDebugDate(){
        MessageVO chatMock = new MessageVO();
        chatMock.setId(1L);
        chatMock.setNickname("ATX-wuying");
        chatMock.setMessage("HELLO HELLO HELLO");
        chatMock.setTimestamp(new Date().getTime());
        chatMock.setSource(MessageSource.CHAT);
        chatListView.getItems().add(chatMock);

        MessageVO applyMock = new MessageVO();
        applyMock.setId(2L);
        applyMock.setNickname("Coffee_Killer");
        applyMock.setTimestamp(new Date().getTime());
        applyMock.setSource(MessageSource.APPLY);
        chatListView.getItems().add(applyMock);
    }

    public void onApplyClick(ActionEvent actionEvent){

    }
}
