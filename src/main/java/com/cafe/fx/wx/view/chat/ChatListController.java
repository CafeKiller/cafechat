package com.cafe.fx.wx.view.chat;

import com.cafe.fx.wx.constant.MessageSource;
import com.cafe.fx.wx.core.FXComponent;
import com.cafe.fx.wx.vo.MessageVO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChatListController implements Initializable {

    public ListView<MessageVO> chatListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        renderDebugDate();
        initializeUI();
        initializeEvent();
    }
    public void initializeUI(){
//        System.err.println(chatListView.getItems());

        chatListView.setCellFactory(f -> new ChatRowController());

    }

    /* 初始化页面事件 */
    public void initializeEvent(){
        chatListView.getSelectionModel().selectedItemProperty().addListener(
                (obj, ov, nv)->{
                    if (Objects.nonNull(nv)){
                        Pane main = FXComponent.mainComponent();
                        main.getChildren().clear();
                        main.getChildren().add(FXComponent.chatMainComponent(nv.getId()));
                    }
                });
    }

    /* 添加 测试数据 */
    void renderDebugDate(){

        MessageVO chatMock = new MessageVO();
        chatMock.setId(233L);
        chatMock.setNickname("ATX-wuying");
        chatMock.setMessage("HELLO HELLO HELLO");
        chatMock.setTimestamp(new Date().getTime());
        chatMock.setSource(MessageSource.CHAT);
        chatListView.getItems().add(chatMock);

        MessageVO applyMock = new MessageVO();
        applyMock.setId(322L);
        applyMock.setNickname("Coffee_Killer");
        applyMock.setTimestamp(new Date().getTime());
        applyMock.setSource(MessageSource.APPLY);
        chatListView.getItems().add(applyMock);
    }

    public void onApplyClick(ActionEvent actionEvent){

    }
}
