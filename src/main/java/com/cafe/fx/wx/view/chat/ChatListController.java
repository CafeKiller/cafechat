package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.vo.MessageVO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatListController implements Initializable {

    public ListView<MessageVO> chatListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeUI();
        initializeEvent();
    }
    public void initializeUI(){
        chatListView.setCellFactory(f -> new ChatRowController());
    }
    public void initializeEvent(){

    }
    public void onApplyClick(ActionEvent actionEvent){

    }
}
